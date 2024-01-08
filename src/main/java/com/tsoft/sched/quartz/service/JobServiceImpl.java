package com.tsoft.sched.quartz.service;

import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private final JobMapper jobMapper;

    @Override
    public void insertJobManage(HashMap<String, Object> params) {
        JobManage jManage = new JobManage();
        jManage.setJobTitle((String) params.get("jobTitle"));
        jManage.setJobDescription((String) params.get("jobDescription"));
        jManage.setJobStartDate((String) params.get("jobStartDate"));
        jManage.setUrl((String) params.get("url"));
        jManage.setParam((String) params.get("param"));

        jobMapper.insertJobManage(jManage);
    }

    @Override
    public List<JobManage> selectAll() {
        System.out.println("진입 : " + jobMapper.selectAll());
        return jobMapper.selectAll();
    }


}
