package com.tsoft.sched.mapper;

import com.tsoft.sched.quartz.model.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

    List<Job> getAllJobs();

    void insertJob(Job job);

    // Add other CRUD operations
}