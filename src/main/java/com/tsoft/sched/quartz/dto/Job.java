package com.tsoft.sched.quartz.dto;

import lombok.Data;

@Data
public class Job {
    private String jobName;
    private String jobGroup;
    private String jobClassName;
}