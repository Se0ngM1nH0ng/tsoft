package com.tsoft.sched.adm.controller;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.ServerManage;
import com.tsoft.sched.adm.service.JobService;
import com.tsoft.sched.adm.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/page")
public class PageController {
    @Value("${container.name}")
    private String containerName;

    private final JobService jobService;
    private final ServerService serverService;


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

    @GetMapping("/scheduleLog")
    public String scheduleLog() {
        return "scheduleLog";
    }

    @GetMapping("/scheduleInsert")
    public String scheduleInsert() {
        return "scheduleInsert";
    }
    @GetMapping("/serverInsert")
    public String serverInsert() {
        return "serverInsert";
    }

    @RequestMapping("/scheduleManage") // job 관리 페이지 목록 조회
    public String scheduleManage(Model model) {

        List<JobManage> jobList = jobService.selectAll();

        model.addAttribute("jobList", jobList);


        return "scheduleManage";
    }


    @RequestMapping("/serverManage") // job 관리 페이지 목록 조회
    public String serverManage(Model model) {

        List<ServerManage> serverList = serverService.serverSelectAll();

        model.addAttribute("serverList", serverList);


        return "serverManage";
    }


}

