package com.shsxctf.results.mappers;

import com.shsxctf.results.models.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class resultsMapper implements RowMapper<Result> {


    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        Result result = new Result();
        result.setId(rs.getInt("idresult_test"));
        result.setDesc(rs.getString("description"));
        result.setRaceId(rs.getInt("idrace"));
        result.setEventId(rs.getInt("idevent"));
        return result;
    }
}
