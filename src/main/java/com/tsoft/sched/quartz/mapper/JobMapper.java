package com.tsoft.sched.quartz.mapper;

import com.tsoft.sched.quartz.dto.JobManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

   void insertJobManage(JobManage jManage);
   List<JobManage> selectAll();
   JobManage selectOne(int jManage);
}