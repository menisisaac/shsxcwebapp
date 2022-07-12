package com.shsxctf.results.mappers;

import com.shsxctf.results.models.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventTestMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setId(rs.getInt("idevent_test"));
        event.setName(rs.getString("name"));
        event.setDate(rs.getString("date"));
        return event;
    }
}
