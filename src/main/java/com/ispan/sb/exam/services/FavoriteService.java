package com.ispan.sb.exam.services;

import com.ispan.sb.exam.Favorite;
import com.ispan.sb.exam.Table1;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.FavoriteRepository;
import com.ispan.sb.exam.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ 加入收藏（如果不存在）
    public boolean addFavorite(User user, Table1 table1) {
        if (favoriteRepository.existsByUserAndTable1(user, table1)) {
            return false; // 已存在
        }

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setTable1(table1);
        favorite.setCreatedAt(LocalDateTime.now());
        favorite.setExpiresAt(LocalDateTime.now().plusDays(30));
        favoriteRepository.save(favorite);
        return true;
    }

    // ✅ 取得使用者所有有效收藏資料（並清除已過期）
    public List<Table1> getAllFavorites(User user) {
        List<Favorite> all = favoriteRepository.findByUser(user);
        LocalDateTime now = LocalDateTime.now();

        List<Favorite> valid = all.stream()
                .filter(f -> f.getExpiresAt() == null || f.getExpiresAt().isAfter(now))
                .collect(Collectors.toList());

        List<Favorite> expired = all.stream()
                .filter(f -> f.getExpiresAt() != null && f.getExpiresAt().isBefore(now))
                .collect(Collectors.toList());

        if (!expired.isEmpty()) {
            favoriteRepository.deleteAll(expired);
        }

        return valid.stream()
                .map(Favorite::getTable1)
                .collect(Collectors.toList());
    }

    // ✅ 切換收藏（已存在就刪除，否則新增）
    public boolean toggleFavorite(User user, Table1 table1) {
        Optional<Favorite> existing = favoriteRepository.findByUserAndTable1(user, table1);
        if (existing.isPresent()) {
            favoriteRepository.delete(existing.get());
            return false; // 已取消
        } else {
            Favorite favorite = new Favorite();
            favorite.setUser(user);
            favorite.setTable1(table1);
            favorite.setCreatedAt(LocalDateTime.now());
            favorite.setExpiresAt(LocalDateTime.now().plusDays(30));
            favoriteRepository.save(favorite);
            return true; // 已收藏
        }
    }

    // ✅ 新增這個方法：取得該使用者收藏的 Table1 資料 ID
    public List<Long> getMyFavoriteIds(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("找不到使用者：" + username));
        return favoriteRepository.findByUser(user).stream()
                .map(fav -> fav.getTable1().getId())
                .collect(Collectors.toList());
    }

}
