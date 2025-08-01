package com.ispan.sb.exam;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "table1_id"})
})
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 使用者關聯（多對一）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 票價資料關聯（多對一）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table1_id", nullable = false)
    private Table1 table1;

    // 收藏時間
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // 過期時間（例如：30 天後自動過期）
    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    // 🧱 Getter / Setter
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Table1 getTable1() {
        return table1;
    }

    public void setTable1(Table1 table1) {
        this.table1 = table1;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
    
}
