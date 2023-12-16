package com.example.test6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CTRL {

    @GetMapping("/")
    public String root (){
        return "index";
    }
}
