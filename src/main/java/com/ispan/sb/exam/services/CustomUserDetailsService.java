package com.ispan.sb.exam.services;

import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("找不到帳號：" + username));

        // ✅ 如果 role 是空，就給預設為 GUEST
        String role = (user.getRole() == null || user.getRole().trim().isEmpty())
                      ? "GUEST"
                      : user.getRole().trim().toUpperCase();

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(role) // ✅ Spring 會自動補上 "ROLE_" 前綴
                .build();
    }
}
