package com.ispan.sb.exam.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.ispan.sb.exam.CartItemDto;
import com.ispan.sb.exam.Order;
import com.ispan.sb.exam.OrderItem;
import com.ispan.sb.exam.Product;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.OrderRequestDto;
import com.ispan.sb.exam.repository.OrderRepository;
import com.ispan.sb.exam.repository.ProductRepository;
import com.ispan.sb.exam.services.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JavaMailSender mailSender;

    // ✅ 建立訂單
    @Transactional
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDto request, Principal principal) {
        List<CartItemDto> cartItems = request.getItems();
        if (cartItems == null || cartItems.isEmpty()) {
            return ResponseEntity.badRequest().body("購物車是空的");
        }

        User user = userService.findByUsername(principal.getName());

        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        order.setPickupLocation(request.getPickupLocation());

        List<OrderItem> items = cartItems.stream().map(item -> {
            // ✅ 使用悲觀鎖查詢
            Product product = productRepository.findByIdWithLock(item.getProductId());
            if (product == null || product.getStock() < item.getQuantity()) {
                throw new IllegalArgumentException("商品不存在或庫存不足：" + item.getProductId());
            }

            // ✅ 扣庫存
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(product.getPrice());
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(items);
        orderRepository.save(order);

        // ✅ 使用填寫的 email 寄信
        sendConfirmationEmail(request.getEmail(), request.getPickupLocation(), order.getId());

        return ResponseEntity.ok("✅ 訂單建立成功，通知已寄送至：" + request.getEmail());
    }

    // ✅ 寄送測試信
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/test-mail")
    public ResponseEntity<?> testMail() {
        String testEmail = "fly155141@gmail.com";
        sendConfirmationEmail(testEmail, "測試門市", 0L);
        return ResponseEntity.ok("✅ 測試信已寄送至：" + testEmail);
    }

    // ✅ 寄送訂單確認信
    private void sendConfirmationEmail(String to, String location, Long orderId) {
        String subject = "【捷運購物】訂單已成立，請至指定門市取貨";
        String content = String.format("""
            感謝您的訂購！

            ✅ 訂單編號：ORD-%d
            🏪 取貨地點：%s

            取貨時請出示此信件或訂單編號。

            — 捷運購物系統 敬上 —
            """, orderId, location);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
