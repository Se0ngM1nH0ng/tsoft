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
        jManage.setJob_title((String) params.get("jobTitle"));
        jManage.setJob_description((String) params.get("jobDescription"));
        jManage.setJob_start_date((String) params.get("jobStartDate"));
        jManage.setUrl((String) params.get("url"));
        jManage.setParam((String) params.get("param"));

        jobMapper.insertJobManage(jManage);
    }

    @Override
    public List<JobManage> selectAll() {
        return jobMapper.selectAll();
    }

    @Override
    public JobManage selectOne(JobManage jManage) {
        return jobMapper.selectOne(jManage.getJob_id());
    }


}
