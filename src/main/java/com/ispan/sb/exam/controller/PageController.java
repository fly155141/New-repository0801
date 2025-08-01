package com.ispan.sb.exam.controller;

import com.ispan.sb.exam.Table1;
import com.ispan.sb.exam.Product;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.FavoriteRepository;
import com.ispan.sb.exam.repository.ProductRepository;
import com.ispan.sb.exam.repository.UserRepository;
import com.ispan.sb.exam.services.Table1Service;
import com.ispan.sb.exam.services.FavoriteService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping
public class PageController {

    @Autowired
    private Table1Service table1Service;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteService favoriteService;

    private String announcement = "暫無公告事項";

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model, Locale locale, Authentication authentication) {
        model.addAttribute("announcement", announcement);
        model.addAttribute("requestUri", request.getRequestURI());

        // ✅ 加入 isAdmin 判斷（可在 dashboard.html 使用 th:if）
        boolean isAdmin = authentication != null &&
                          authentication.getAuthorities().stream()
                              .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);

        return "dashboard";
    }

    @GetMapping("/fragment/welcome")
    public String fragmentWelcome(Model model, Locale locale) {
        model.addAttribute("announcement", announcement);
        return "fragment/welcome";
    }

    @GetMapping("/fragment/price")
    public String fragmentPrice(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder,
            Model model,
            Authentication authentication,
            Locale locale) {

    	Page<Table1> resultPage = table1Service.searchAndSort(keyword, page, sortField, sortOrder);
        List<Long> favorites = favoriteService.getMyFavoriteIds(authentication);

        model.addAttribute("searchKeyword", keyword);
        model.addAttribute("page", resultPage);
        model.addAttribute("favorites", favorites);

        boolean isAdmin = authentication != null &&
                          authentication.getAuthorities().stream()
                              .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);

        return "fragment/price";
    }




    @GetMapping("/fragment/map")
    public String fragmentMap(Model model, Locale locale) {
        model.addAttribute("announcement", announcement);
        return "fragment/map";
    }

    @GetMapping("/fragment/shop")
    public String fragmentShop(Model model, Locale locale, Authentication authentication) {
        List<Product> products = productRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("products", products);
        model.addAttribute("announcement", announcement);

        boolean isAdmin = authentication != null &&
                          authentication.getAuthorities().stream()
                              .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        model.addAttribute("isAdmin", isAdmin);

        return "fragment/shop";
    }


    @RestController
    @RequestMapping("/api")
    public static class AnnouncementApiController {

        private final PageController parent;

        public AnnouncementApiController(PageController parent) {
            this.parent = parent;
        }

        @GetMapping("/announcement")
        public String getAnnouncement() {
            return parent.announcement;
        }

        @PostMapping("/announcement")
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<?> updateAnnouncement(@RequestBody Map<String, String> body) {
            String content = body.get("content");
            if (content != null && !content.trim().isEmpty()) {
                parent.announcement = content;
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.badRequest().body("公告不得為空");
        }
    }
}
