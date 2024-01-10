package com.tsoft.sched.adm.dto;

import lombok.Data;

@Data
public class JobManage {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobStartDate;
    private int jobStatus;
    private String url;
    private String param;
    private String jobAction;
    private String jobRegDate;
    private String jobModifyDate;
    private String serverGroup;
}
