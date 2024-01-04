package com.tsoft.sched.quartz.mapper;//package com.tsoft.sched.quartz.mapper;

import com.tsoft.sched.quartz.dto.Job;
import com.tsoft.sched.quartz.dto.Trigger;
import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.annotation.MapperScan;

@Mapper
//@MapperScan(basePackages = {"com.tsoft.sched.quartz.mapper"})
public interface QuartzMapper {

    void insertJob(Job job);

    void insertTrigger(Trigger trigger);

    // Add other CRUD operations

}