package com.tsoft.sched.quartz.service;

import com.tsoft.sched.quartz.dto.JobManage;

import java.util.HashMap;
import java.util.List;

public interface JobService {
    void insertJobManage(HashMap<String, Object> params);
    List<JobManage> selectAll();
}
