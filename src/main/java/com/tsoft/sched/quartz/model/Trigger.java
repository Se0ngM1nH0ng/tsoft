package com.tsoft.sched.quartz.model;

import lombok.Data;

@Data
public class Trigger {
    private String triggerName;
    private String triggerGroup;
    private String jobName;
    private String jobGroup;
    private String cronExpression;
}