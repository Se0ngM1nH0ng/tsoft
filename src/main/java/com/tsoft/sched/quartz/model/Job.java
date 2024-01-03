package com.tsoft.sched.quartz.model;

import lombok.Data;

@Data
public class Job {
    private String jobName;
    private String jobGroup;
    private String jobClassName;
}