package com.cos.security3.config;

import com.cos.security3.filter.JwtAuthenticationFilter;
import com.cos.security3.jwt.TokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;

    public JwtSecurityConfig(TokenProvider tokenProvider){
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception{
        JwtAuthenticationFilter memberFilter = new JwtAuthenticationFilter(tokenProvider); // 토큰 필터를 jwt 패키지에 추가
        builder.addFilterBefore(memberFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
