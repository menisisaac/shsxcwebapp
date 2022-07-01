package com.shsxctf.Scheduler.models;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EmailRequest {

    @NotEmpty
    private String recipientEmails;
    @NotEmpty
    private String subject;
    @NotEmpty
    private boolean isAnnouncement;
    @NotEmpty
    private String body;
    @NotEmpty
    private LocalDateTime dateTime;
    @NotEmpty
    private ZoneId  timeZone;

    public String getRecipientEmails() {
        return recipientEmails;
    }

    public void setRecipientEmails(String recipientEmails) {
        this.recipientEmails = recipientEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isAnnouncement() {
        return isAnnouncement;
    }

    public void setAnnouncement(boolean announcement) {
        isAnnouncement = announcement;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }
}
