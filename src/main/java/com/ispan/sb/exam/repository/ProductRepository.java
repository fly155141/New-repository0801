package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name); // ✅ 用名稱查找

    List<Product> findAllByOrderByCreatedAtDesc(); // ✅ 建立時間降序

    // ✅ 加入悲觀鎖的查詢（避免多個會員同時搶購）
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product findByIdWithLock(@Param("id") Long id);
}
