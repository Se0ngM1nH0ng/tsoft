package com.tsoft.sched.adm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @Value("${container.name}")
    private String containerName;
    @GetMapping("/hello")
    public String hello() {
        System.out.printf("containerName : " + containerName);
        return "hello";
    }
    @GetMapping("/chart")
    public String chart() {
        return "chart";
    }
    @GetMapping("/grid")
    public String grid() {
        return "grid";
    }
    @GetMapping("/editor")
    public String editor() {
        return "editor";
    }
    @GetMapping("/quartz")
    public String scheduleJob() {
        return "quartz/scheduleJob";
    }
    @GetMapping("/view")
    public String view() {
        return "view";
    }
    @GetMapping("/popup")
    public String popup() {
        return "popup";
    }
}