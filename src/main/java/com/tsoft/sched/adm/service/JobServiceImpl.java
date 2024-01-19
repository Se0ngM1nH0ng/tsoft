package com.tsoft.sched.adm.service;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.Page;
import com.tsoft.sched.adm.dto.SearchDto;
import com.tsoft.sched.adm.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobMapper jobMapper;

    @Override
    public void insertJobManage(HashMap<String, Object> params) {
        try {
            JobManage jManage = new JobManage();
            jManage.setJobTitle((String) params.get("jobTitle"));
            jManage.setJobDescription((String) params.get("jobDescription"));
            jManage.setJobStartDate((String) params.get("jobStartDate"));
            jManage.setServerGroup((String) params.get("serverGroup"));
            jManage.setUrl((String) params.get("url"));
            jManage.setParam((String) params.get("param"));

            jobMapper.insertJobManage(jManage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<JobManage> selectAll() {
        return jobMapper.selectAll();
    }

    @Override
    public JobManage selectOne(JobManage jManage) {

        JobManage jobManage = jobMapper.selectOne(jManage);
        List<JobManage> jobManageList = jobMapper.selectAll();

        return jobMapper.selectOne(jManage);
    }

    @Override
    public void update(HashMap<String, Object> params) {
        try{
            JobManage jManage = new JobManage();
            jManage.setJobTitle((String)params.get("jobTitle"));
            jManage.setJobDescription((String)params.get("jobDescription")); // ajax 에서 넘겨준 key 이름
            jManage.setJobStartDate((String)params.get("jobStartDate")); // ajax 에서 넘겨준 key 이름
            jManage.setUrl((String)params.get("url"));
            jManage.setParam((String)params.get("param"));
            jManage.setJobId((Integer) params.get("jobId"));

            jobMapper.update(jManage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int hiddenJobId) {
        jobMapper.delete(hiddenJobId);
    }

    @Override
    public List<JobManage> findAllPost(SearchDto params) {
        return jobMapper.findAll(params);
    }


}
