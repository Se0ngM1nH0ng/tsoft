package com.tsoft.sched.quartz.service;

import com.tsoft.sched.quartz.dto.Job;
import com.tsoft.sched.quartz.dto.Trigger;

public interface QuartzService {
    void addJob(Job job, Trigger trigger);

    // Add other CRUD operations
}