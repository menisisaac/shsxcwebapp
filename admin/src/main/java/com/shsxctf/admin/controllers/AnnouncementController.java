package com.shsxctf.admin.controllers;

import com.shsxctf.admin.mappers.AnnoucementMapper;
import com.shsxctf.admin.models.Annoucement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    JdbcTemplate template;

    @GetMapping("/announcement")
    @CrossOrigin
    public List<Annoucement> getAnnouncements() {
        String sql = "SELECT * FROM announcement";
        return template.query(sql, new AnnoucementMapper());
    }

    @PostMapping("/annoucement")
    @CrossOrigin
    public void addAnnoucement() {
        String sql = "INSERT INTO announcement(date, description) VALUES (?, ?)";
    }

    public void editAnnoucement() {
    }

    public void deleteMapping() {
    }

}
