package com.tsoft.sched.adm.mapper;

import com.tsoft.sched.adm.dto.JobManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

   void insertJobManage(JobManage jManage);
   List<JobManage> selectAll();
   JobManage selectOne(int jManage);
   void update(JobManage jManage);
   void delete(int hiddenJobId);
}