package com.akoca.exercise.config.quartz;

import com.akoca.exercise.quartzjobs.EmailSenderQuartz;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
@EnableScheduling
@ConditionalOnExpression("'${custom.enable-quartz}'=='false'")
public class EmailSenderJobConfig {

    @Bean
    public JobDetail scheduleEmailSendingJobDetail() {
        return
            JobBuilder
                .newJob(EmailSenderQuartz.class)
                .storeDurably()
                .withIdentity("emailSenderJob")
                .withDescription("Sends emails periodically")
                .usingJobData("subject" , "Quartz Try")
                .usingJobData("body" , "Trying Quartz With Spring")
                .usingJobData("email" , "ahmet.koca@hotmail.com")
            .build();
    }

    @Bean
    public Trigger scheduleEmailSendingTrigger() {
        return newTrigger()
                .withIdentity("emailTrigger")
                .forJob(scheduleEmailSendingJobDetail())
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                .usingJobData("randomString" , UUID.randomUUID().toString())
                .build();
    }
}