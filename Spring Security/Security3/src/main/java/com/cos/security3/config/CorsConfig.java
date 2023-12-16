package com.cos.security3.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답할 때 JSON을 JS에서 처리할 수 있게 함
        config.addAllowedOrigin("*"); // 모든 IP에 응답을 허용
        config.addAllowedMethod("*"); // 모든 HTTP 메서드를 허용
        config.addAllowedHeader("*"); // 모든 헤더에 응답을 허용
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
