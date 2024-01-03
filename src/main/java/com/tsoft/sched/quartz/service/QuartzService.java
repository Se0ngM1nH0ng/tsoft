package com.tsoft.sched.quartz.service;

import com.tsoft.sched.quartz.model.Job;
import com.tsoft.sched.quartz.model.Trigger;

public interface QuartzService {
    void addJob(Job job, Trigger trigger);

    // Add other CRUD operations
}