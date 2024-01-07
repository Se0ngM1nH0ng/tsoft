package com.tsoft.sched.quartz.mapper;

import com.tsoft.sched.quartz.dto.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobMapper {

   boolean insertJobManage(Map<String, String> map);
    // Add other CRUD operations
}