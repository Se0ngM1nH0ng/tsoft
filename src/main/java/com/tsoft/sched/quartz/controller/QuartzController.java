package com.tsoft.sched.quartz.controller;

import com.tsoft.sched.quartz.dto.Job;
import com.tsoft.sched.quartz.dto.Trigger;
import com.tsoft.sched.quartz.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    private final QuartzService quartzService;

    @Autowired
    public QuartzController(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    @PostMapping("/addJob")
    public ResponseEntity<String> addJob(@RequestBody Job job, @RequestBody Trigger trigger) {
        quartzService.addJob(job, trigger);
        return ResponseEntity.ok("Job and Trigger added successfully");
    }

    // Add other controller methods for CRUD operations
}
