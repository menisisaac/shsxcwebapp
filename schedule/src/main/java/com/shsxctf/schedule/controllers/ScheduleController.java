package com.shsxctf.schedule.controllers;

import com.shsxctf.schedule.mappers.EventMapper;
import com.shsxctf.schedule.models.Event;
import com.shsxctf.schedule.services.ScheduleUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ScheduleController {

    @Autowired
    JdbcTemplate template;


    @PostMapping("/schedule")
    @CrossOrigin
    public void refreshSchedule() {
        ScheduleUpdate scheduleUpdate = new ScheduleUpdate();
        scheduleUpdate.updateSchedule(template);
    }

    @GetMapping("/schedule")
    @CrossOrigin
    public List<Event> getSchedule() {
        String sql = "SELECT * FROM event";
        List<Event> events = template.query(sql, new EventMapper());
        List<Event> postToday = new ArrayList<>();
        Date curr = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        for(Event e : events) {
            try {
                if(!curr.after(formatter.parse(e.getDate()))) {
                    postToday.add(e);
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(postToday.isEmpty()) {
            return events;
        }
        return postToday;
    }
}

