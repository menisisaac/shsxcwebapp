package com.shsxctf.results.mappers;

import com.shsxctf.results.models.Result;
import com.shsxctf.results.models.Race;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RaceTestMapper implements RowMapper<Race> {

    @Override
    public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
        Race race = new Race();
        race.setId(rs.getInt("idrace_test"));
        race.setName(rs.getString("raceName"));
        race.setEventId(rs.getInt("idevent"));
        return race;
    }
}
