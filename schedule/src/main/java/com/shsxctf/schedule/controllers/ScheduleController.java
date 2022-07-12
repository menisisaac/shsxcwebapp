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

import java.util.Collections;
import java.util.List;

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
        Collections.sort(events);
        return events;
    }
}

