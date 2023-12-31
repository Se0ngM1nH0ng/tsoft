package com.example.securitytest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class SecurityTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityTest1Application.class, args);
    }

}

