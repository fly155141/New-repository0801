package com.ispan.sb.exam;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by") // 對應資料庫欄位
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    // ✅ 新增訂單狀態欄位（預設為 PENDING）
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    private String pickupLocation;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getter / Setter =====
    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference  // ✅ 防止無限遞迴
    public List<OrderItem> getItems() {
        return items;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    @Transient
    public int getTotalAmount() {
        return items.stream().mapToInt(item -> item.getPrice() * item.getQuantity()).sum();
    }
}
