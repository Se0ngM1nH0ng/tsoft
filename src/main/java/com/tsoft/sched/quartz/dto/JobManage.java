package com.tsoft.sched.quartz.dto;

import lombok.Data;

@Data
public class JobManage {
    private int job_id;
    private String job_title;
    private String job_description;
    private String job_start_date;
    private String job_status;
    private String url;
    private String param;
    private String job_action;
    private String job_reg_date;
    private String job_modify_date;
}
