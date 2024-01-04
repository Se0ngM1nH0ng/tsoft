package com.tsoft.sched.quartz.mapper;

import com.tsoft.sched.quartz.dto.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

    List<Job> getAllJobs();

    void insertJob(Job job);

    // Add other CRUD operations
}