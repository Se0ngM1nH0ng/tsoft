package com.example.test3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CTRL {

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/")

    public String root(){
        return "test";
    }

    @GetMapping("/user")
    public String memberPage(){

        return "member";
    }

    @GetMapping("/admin")
    public String adminPage(){

        return "admin";
    }

}
