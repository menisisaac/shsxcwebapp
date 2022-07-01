package com.shsxctf.Scheduler.jobs;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

public class EmailJob extends QuartzJobBean {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailProperties mailProperties;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String subject = jobDataMap.getString("subject");
        String isAnnouncement = jobDataMap.getString("isAnnouncement");
        if (isAnnouncement.equals("true")) {
            subject = "Announcement: " + subject;
        }
        String body = jobDataMap.getString("body");
        String[] recipientEmails = jobDataMap.getString("recipientEmails").split(" ");

        for (String s : recipientEmails) {
            sendMail(mailProperties.getUsername(), s, subject, body);
        }
    }

    private void sendMail(String fromEmail, String toEmail, String subject, String body) {
        try {


            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
            messageHelper.setSubject(subject);
            messageHelper.setText(body, true);
            messageHelper.setFrom(fromEmail);
            messageHelper.setTo(toEmail);

            mailSender.send(message);
        } catch (MessagingException ex) {
        }
    }
}
