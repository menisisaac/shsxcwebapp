package com.shsxctf.schedule.services;

import com.shsxctf.schedule.mappers.EventMapper;
import com.shsxctf.schedule.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.Set;

public class ScheduleUpdate {


    public void updateSchedule(JdbcTemplate template) {

        ScheduleGenerator generator = new ScheduleGenerator();
        generator.scrapeSchedule();
        Set<Event> events = generator.getEvents();
        String sqlGet = "SELECT * FROM event";
        String sqlInsert = "INSERT INTO event (name, date, location) VALUES (?, ?, ?)";
        Set<Event> pastEvents = new HashSet(template.query(sqlGet, new EventMapper()));
        for(Event e : events) {
            if(!pastEvents.contains(e)) {
                template.update(sqlInsert, e.getName(), e.getDate(), e.getLocation());
            }
        }
    }
}
