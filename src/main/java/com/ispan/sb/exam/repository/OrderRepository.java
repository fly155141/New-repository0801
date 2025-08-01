package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // 可自定義查詢方法，例如：
    // List<Order> findByCreatedBy(User user);
}
