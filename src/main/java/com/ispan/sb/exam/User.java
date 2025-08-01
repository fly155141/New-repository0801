package com.ispan.sb.exam;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "table2")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "帳號", nullable = false, unique = true)
    private String username;

    @Column(name = "密碼", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    // ✅ Getter / Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ✅ 實作 UserDetails 方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + role); // Spring Security 權限需加上 ROLE_
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 不過期
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 不鎖定
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 憑證不過期
    }

    @Override
    public boolean isEnabled() {
        return true; // 啟用
    }
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
