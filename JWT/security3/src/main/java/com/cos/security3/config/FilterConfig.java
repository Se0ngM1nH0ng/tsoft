//package com.cos.security3.config;
//
//import com.cos.security3.filter.MyFilter2;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig { // 필터를 하나 만든다.
//
//    @Bean
//    public FilterRegistrationBean<JwtAuthenticationFilter> filter1(){
//        FilterRegistrationBean<JwtAuthenticationFilter> bean = new FilterRegistrationBean<>(new JwtAuthenticationFilter());
//        bean.addUrlPatterns("/*");
//        bean.setOrder(0); // 낮은 번호가 필터 중에서 가장 먼저 실행됨 (우선순위 같은 느낌)
//        return bean;
//
//    }
//
//    @Bean
//    public FilterRegistrationBean<MyFilter2> filter2(){
//        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2());
//        bean.addUrlPatterns("/*");
//        bean.setOrder(1); // 낮은 번호가 필터 중에서 가장 먼저 실행됨 (우선순위 같은 느낌)
//        return bean;
//
//    }
//}
