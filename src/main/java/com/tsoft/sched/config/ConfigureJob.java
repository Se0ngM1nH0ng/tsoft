package com.tsoft.sched.config;

import com.tsoft.sched.quartz.job.ExecuteJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    @Conditional(QuartzCondition.class)
    public JobDetail jobADetails() {
        return JobBuilder.newJob(ExecuteJob.class)
                .withIdentity("Job")
                .storeDurably().build();
    }

    @Bean
    @Conditional(QuartzCondition.class)
    public Trigger jobATrigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * ? * * *"))
                .build();
    }
}