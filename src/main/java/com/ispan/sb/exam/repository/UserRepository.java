package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ✅ 查詢帳號（來自資料表 table2 的「帳號」欄位）
	@Query(value = "SELECT * FROM table2 WHERE 帳號 = :username", nativeQuery = true)
	Optional<User> findByUsername(@Param("username") String username);

 // 根據帳號查詢使用者（假設欄位名稱為「帳號」）
    
}
