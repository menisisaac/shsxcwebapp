package com.shsxctf.Scheduler.controllers;

import com.shsxctf.Scheduler.jobs.EmailJob;
import com.shsxctf.Scheduler.models.EmailRequest;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@RestController
public class EmailController {

    @Autowired
    private Scheduler scheduler;

    @PostMapping("/scheduleEmail")
    public void scheduleEmail(@RequestBody EmailRequest emailRequest) {
        try {
            ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.getDateTime(), emailRequest.getTimeZone());
            JobDetail jobDetail = buildJobDetail(emailRequest);
            Trigger trigger = buildJobTrigger(jobDetail, dateTime);
            scheduler.scheduleJob(jobDetail, trigger);






        } catch(SchedulerException ex) {

        }
    }

    private JobDetail buildJobDetail(EmailRequest request) {
        JobDataMap jobDataMap = new JobDataMap();

        jobDataMap.put("email", request.getRecipientEmails());
        jobDataMap.put("subject", request.getSubject());
        jobDataMap.put("body", request.getBody());

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(UUID.randomUUID().toString(), "email-jobs")
                .withDescription("Send Email Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
