package com.shsxctf.results.mappers;

import com.shsxctf.results.models.Season;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeasonMapper implements RowMapper<Season> {

    @Override
    public Season mapRow(ResultSet rs, int rowNum) throws SQLException {
        Season season = new Season(rs.getString("season"));
        return season;
    }
}
