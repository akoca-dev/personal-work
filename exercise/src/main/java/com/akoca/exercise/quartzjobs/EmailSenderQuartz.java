package com.akoca.exercise.quartzjobs;

import com.akoca.exercise.util.CommonUtils;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Component
public class EmailSenderQuartz extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderQuartz.class);

    private JavaMailSender javaMailSender;
    private MailProperties mailProperties;

    @Autowired
    public EmailSenderQuartz(JavaMailSender javaMailSender , MailProperties mailProperties) {
        CommonUtils.nullCheckArguments(javaMailSender , mailProperties);

        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("Executing Job With Key: {}" , jobExecutionContext.getJobDetail().getKey());

        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String subject = jobDataMap.getString("subject");
        String body = jobDataMap.getString("body");
        String recipientEmail = jobDataMap.getString("email");
        String randomString = jobDataMap.getString("randomString");

        sendMail(mailProperties.getUsername() , recipientEmail , subject + "-" + randomString, body);

        LOGGER.info("Executed Job With Key: {}" , jobExecutionContext.getJobDetail().getKey());
    }

    private void sendMail(String from , String to , String subject , String body) {
        LOGGER.info("Sending Email to {}" , to);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , StandardCharsets.UTF_8.toString());

        try {
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body , true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException messagingEx) {
            LOGGER.error("Sending email to {} failed" , to);
        }
    }
}