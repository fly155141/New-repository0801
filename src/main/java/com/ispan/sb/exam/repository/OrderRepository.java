package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.Order;
import com.ispan.sb.exam.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // 可自定義查詢方法，例如：
    // List<Order> findByCreatedBy(User user);
	List<Order> findByUser(User user); // 可選，若你未來要查使用者訂單

}
