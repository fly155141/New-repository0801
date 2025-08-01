package com.ispan.sb.exam.controller;

import com.ispan.sb.exam.Favorite;
import com.ispan.sb.exam.Table1;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.services.FavoriteService;
import com.ispan.sb.exam.services.Table1Service;
import com.ispan.sb.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private Table1Service table1Service;

    // ✅ 切換收藏（登入者皆可）
    @PostMapping("/toggle/{id}")
    public ResponseEntity<String> toggleFavorite(@PathVariable("id") Long table1Id, Authentication auth) {
        if (auth == null || auth.getName() == null) {
            return ResponseEntity.status(401).body("favorite.error"); // ✅ 改為 i18n key
        }

        User user = userService.findByUsername(auth.getName());
        Table1 table1 = table1Service.findById(table1Id);

        if (table1 == null) {
            return ResponseEntity.status(404).body("favorite.error"); // ✅ 改為 i18n key
        }

        boolean isFavorited = favoriteService.toggleFavorite(user, table1);
        return ResponseEntity.ok(isFavorited ? "favorite.add" : "favorite.remove"); // ✅ 回傳 i18n key
    }

    // ✅ 取得我的收藏資料（登入者皆可）
    @GetMapping("/my")
    public ResponseEntity<List<Table1>> getMyFavorites(Authentication auth) {
        if (auth == null || auth.getName() == null) {
            return ResponseEntity.status(401).build();
        }

        User user = userService.findByUsername(auth.getName());
        List<Table1> favorites = favoriteService.getAllFavorites(user);
        return ResponseEntity.ok(favorites);
    }
}
