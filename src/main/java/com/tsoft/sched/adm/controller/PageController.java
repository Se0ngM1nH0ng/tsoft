package com.tsoft.sched.adm.controller;

import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/scheduleManage") // job 관리 페이지 목록 조회
    public String scheduleManage(Model model ) {

        List<JobManage> jobList = jobService.selectAll();

        // JobStatus ENUM으로 변환하여 모델에 추가
        List<Integer> statusList = jobList.stream()
                .map(job -> Integer.parseInt(job.getJob_status()))
                .collect(Collectors.toList());

        model.addAttribute("jobList", jobList);
        model.addAttribute("statusList", statusList);


        return "scheduleManage";
    }
}

