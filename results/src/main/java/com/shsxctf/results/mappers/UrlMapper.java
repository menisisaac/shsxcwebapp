package com.shsxctf.results.mappers;

import com.shsxctf.results.models.ResultUrl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UrlMapper implements RowMapper<ResultUrl> {


    @Override
    public ResultUrl mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultUrl resultUrl = new ResultUrl();
        resultUrl.setId(rs.getInt("idurl"));
        resultUrl.setUrl(rs.getString("url"));
        resultUrl.setName(rs.getString("name"));
        return resultUrl;
    }
}
