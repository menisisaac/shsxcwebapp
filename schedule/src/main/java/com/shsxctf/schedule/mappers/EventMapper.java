package com.shsxctf.schedule.mappers;

import com.shsxctf.schedule.models.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getInt("idevent"));
        event.setDate(rs.getString("date"));
        event.setLocation(rs.getString("location"));
        event.setName(rs.getString("name"));
        event.setTime(rs.getString("time"));
        return event;
    }
}
