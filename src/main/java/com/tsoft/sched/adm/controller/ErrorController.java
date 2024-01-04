package com.tsoft.sched.adm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
}