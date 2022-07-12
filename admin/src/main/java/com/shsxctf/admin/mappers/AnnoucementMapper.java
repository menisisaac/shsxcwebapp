package com.shsxctf.admin.mappers;

import com.shsxctf.admin.models.Annoucement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnnoucementMapper implements RowMapper<Annoucement> {

    @Override
    public Annoucement mapRow(ResultSet rs, int rowNum) throws SQLException {
        Annoucement annoucement = new Annoucement();
        annoucement.setDate(rs.getString("date"));
        annoucement.setId(rs.getInt("idannouncement"));
        annoucement.setText(rs.getString("description"));
        return annoucement;
    }
}
