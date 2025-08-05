package com.ispan.sb.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.annotation.PostConstruct;

import java.io.File;
import java.nio.file.Paths;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // ✅ 靜態資源處理
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    String absolutePath = Paths.get("uploads/images").toAbsolutePath().toUri().toString();
	    registry.addResourceHandler("/uploads/images/**")
	            .addResourceLocations(absolutePath);
	}

    // ✅ 語系切換攔截器：支援 ?lang=en
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    // ✅ 使用 Session 記錄語系（預設繁體中文）
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("zh-TW"));
        return resolver;
    }

    // ✅ 註冊攔截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
    @PostConstruct
    public void createUploadDirIfNotExist() {
        File dir = new File("uploads/images");
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("✅ 建立資料夾：uploads/images");
        }
    }
}
