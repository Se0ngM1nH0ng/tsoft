package com.tsoft.sched.adm.service;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.Page;
import com.tsoft.sched.adm.dto.SearchDto;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;

public interface JobService {
    void insertJobManage(HashMap<String, Object> params);
    List<JobManage> selectAll();
    JobManage selectOne(JobManage jManage);
    void update(HashMap<String, Object> params);
    void delete(int hiddenJobId);
    List<JobManage> findAllPost (final SearchDto params);

}
