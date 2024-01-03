package com.tsoft.sched.quartz.service;

import com.tsoft.sched.mapper.QuartzMapper;
import com.tsoft.sched.quartz.model.Job;
import com.tsoft.sched.quartz.model.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// com.example.service.impl.QuartzServiceImpl
@Service
public class QuartzServiceImpl implements QuartzService {

    private final QuartzMapper quartzMapper;

    @Autowired
    public QuartzServiceImpl(QuartzMapper quartzMapper) {
        this.quartzMapper = quartzMapper;
    }

    @Override
    public void addJob(Job job, Trigger trigger) {
        quartzMapper.insertJob(job);
        quartzMapper.insertTrigger(trigger);
    }

    // Implement other CRUD operations
}
