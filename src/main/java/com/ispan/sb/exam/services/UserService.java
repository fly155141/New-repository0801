package com.ispan.sb.exam.services;

import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ 註冊（不加密）
    public void register(User user) {
        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            user.setRole("USER");
        }
        userRepository.save(user);
    }

    // ✅ 檢查帳號是否存在
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // ✅ 尋找使用者（自訂用途）
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // ✅ 驗證帳號密碼（不加密驗證）
    public boolean authenticate(String username, String password) {
        User user = findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    // ✅ Spring Security 用（登入驗證）
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("使用者不存在：" + username));
    }

    // ✅ 可選的管理用途：依 ID 查找
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    // ✅ 可選的管理用途：查詢全部
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
