package com.ispan.sb.exam.config;

import com.ispan.sb.exam.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // ✅ 主安全配置
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index", "/auth/register", "/auth/checkUsername", "/css/**", "/js/**").permitAll()
                .requestMatchers("/fragment/**").authenticated()
                .requestMatchers("/api/upload", "/api/deleteAll", "/api/add", "/api/update/**", "/api/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/index")                    // 登入頁
                .loginProcessingUrl("/login")           // Spring Security 自動處理
                .defaultSuccessUrl("/dashboard", true)  // 登入成功導向
                .failureUrl("/index?error=true")        // 登入失敗導向
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .sessionManagement(session -> session
                .invalidSessionUrl("/index?timeout=true")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/index?timeout=true")
            )
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .authenticationProvider(authenticationProvider()); // ✅ 註冊 DaoAuthenticationProvider

        return http.build();
    }

    // ✅ 使用明文密碼（開發用，正式建議用 BCryptPasswordEncoder）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // ✅ 指定使用的驗證提供者（含你的 CustomUserDetailsService）
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // ✅ 提供 AuthenticationManager（某些地方可能會注入用到）
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
