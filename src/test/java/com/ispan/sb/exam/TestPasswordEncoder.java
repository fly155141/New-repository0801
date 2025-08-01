package com.ispan.sb.exam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPasswordEncoder {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // 在這裡輸入你想要加密的密碼
        String rawPassword = "你的密碼"; 
        
        String encodedPassword = encoder.encode(rawPassword);
        
        System.out.println("加密後的密碼為: " + encodedPassword);
    }
}
