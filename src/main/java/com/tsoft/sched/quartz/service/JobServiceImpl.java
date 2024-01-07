package com.tsoft.sched.quartz.service;

import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private final JobMapper jobMapper;

    @Override
    public boolean insertJobManage(JobManage jManage) {
        Map<String, String> map = new HashMap<String , String>();
        map.put("jobTitle", jManage.getJobTitle());
        map.put("jobBody", jManage.getJobBody());
        map.put("jobStartDate", jManage.getJobStartDate());
        map.put("jobStatus" , jManage.getJobStatus());
        return jobMapper.insertJobManage(map);
    }
}
