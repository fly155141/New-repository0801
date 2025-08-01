package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.Favorite;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.Table1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // 🔍 查詢某使用者的所有收藏
    List<Favorite> findByUser(User user);

    // 🔍 查詢未過期的收藏
    List<Favorite> findByUserAndExpiresAtAfter(User user, LocalDateTime now);

    // 🔍 查詢是否已收藏特定資料
    Optional<Favorite> findByUserAndTable1(User user, Table1 table1);

    // ✅ 判斷是否已收藏
    boolean existsByUserAndTable1(User user, Table1 table1);

    // ❌ 取消收藏
    void deleteByUserAndTable1(User user, Table1 table1);

    // 🧹 資料刪除時一併清除收藏
    void deleteByTable1(Table1 table1);

    // 🔽 查詢會員收藏的 table1.id 清單（用於前端比對）
    @Query("SELECT f.table1.id FROM Favorite f WHERE f.user.id = :userId")
    List<Long> findTable1IdsByUser(@Param("userId") Integer userId);
}
