package com.tsoft.sched.adm.service;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.mapper.JobMapper;
import com.tsoft.sched.adm.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

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
        return jobMapper.selectAll();
    }

    @Override
    public JobManage selectOne(JobManage jManage) {
        return jobMapper.selectOne(jManage.getJobId());
    }

    @Override
    public void update(HashMap<String, Object> params) {
        JobManage jManage = new JobManage();
        jManage.setJobTitle((String)params.get("jobTitle"));
        jManage.setJobDescription((String)params.get("jobDescription")); // ajax 에서 넘겨준 key 이름
        jManage.setUrl((String)params.get("url"));
        jManage.setParam((String)params.get("param"));
        jManage.setJobStatus((String)params.get("jobStatus"));
        jManage.setJobId((Integer) params.get("jobId"));

        jobMapper.update(jManage);
    }

    @Override
    public void delete(int hiddenJobId) {
        jobMapper.delete(hiddenJobId);
    }


}
