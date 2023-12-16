package com.example.test5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Test5Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Test5Application.class, args);
    }

    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder){
        return builder.sources(Test5Application.class);
    }

}
