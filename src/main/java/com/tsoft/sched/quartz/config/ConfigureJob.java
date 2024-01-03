package com.tsoft.sched.quartz.config;

import com.tsoft.sched.quartz.job.ExecuteJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(ExecuteJob.class)
                .withIdentity("Job")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobDetail) {

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * ? * * *"))
                .build();
    }
}