package com.tsoft.sched.quartz.job;

import com.tsoft.sched.quartz.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RequiredArgsConstructor
public class ExecuteJob implements Job {

    private final TestService testService;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            log.info("Job started on instance: " + jobExecutionContext.getScheduler().getSchedulerInstanceId());

            String triggerName = jobExecutionContext.getTrigger().getKey().getName();
            log.info("Trigger Name: " + triggerName);

            for (int i = 0; i < 1; i++) {
                executorService.submit(testService::hello);
            }

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }


    }
}
