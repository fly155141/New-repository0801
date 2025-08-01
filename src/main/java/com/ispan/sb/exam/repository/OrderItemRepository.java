package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // 可依需求擴充，例如查詢某訂單下的所有品項
}
