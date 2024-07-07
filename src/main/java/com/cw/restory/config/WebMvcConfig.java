package com.cw.restory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://dev.restory.site", "https://api.restory.site")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600); // 1시간 동안 캐시된 CORS 설정 유지
    }
}

