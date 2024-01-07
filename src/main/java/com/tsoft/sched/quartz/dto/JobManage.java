package com.tsoft.sched.quartz.dto;

import lombok.Data;

@Data
public class JobManage {
    private int jobId;
    private String jobTitle;
    private String jobBody;
    private String jobStartDate;
    private String jobStatus;
    private String jobRegDate;
}
