package com.ispan.sb.exam.controller;

import com.ispan.sb.exam.User;
import com.ispan.sb.exam.UserDto;
import com.ispan.sb.exam.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // 註冊頁面
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // 處理註冊請求
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        if (userDto.getUsername().isBlank() || userDto.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("帳號與密碼皆不得為空");
        }
        if (userService.usernameExists(userDto.getUsername())) {
            return ResponseEntity.badRequest().body("帳號已存在");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // ✅ 不加密儲存
        userService.register(user);

        return ResponseEntity.ok("註冊成功");
    }

    // 檢查帳號是否存在（AJAX 用）
    @GetMapping("/checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam String username) {
        return userService.usernameExists(username);
    }

    // 處理登入請求
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request
    ) {
        User user = userService.findByUsername(username);

        if (user == null) {
            request.setAttribute("usernameError", "帳號錯誤");
            return "index";
        }

        if (!user.getPassword().equals(password)) {
            request.setAttribute("passwordError", "密碼錯誤");
            return "index";
        }

        // 登入成功 → 建立 Session
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", user);

        return "redirect:/dashboard"; // ✅ 成功登入跳轉 dashboard
    }

    // 登出功能
    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "OK"; // 前端收到 OK 後導回首頁
    }
}
