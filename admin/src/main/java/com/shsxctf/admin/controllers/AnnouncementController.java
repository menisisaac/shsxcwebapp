package com.shsxctf.admin.controllers;

import com.shsxctf.admin.mappers.AnnoucementMapper;
import com.shsxctf.admin.models.Annoucement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    JdbcTemplate template;

    @PostMapping("/announcement")
    @CrossOrigin
    public Annoucement addAnnoucement(@RequestBody Annoucement annoucement) {
        String sql = "INSERT INTO announcement(date, description) VALUES (?, ?)";
        template.update(sql, annoucement.getDate(), annoucement.getText());
        return annoucement;
    }

    @GetMapping("/announcement")
    @CrossOrigin
    public List<Annoucement> getAnnouncements() {
        String sql = "SELECT * FROM announcement";
        return template.query(sql, new AnnoucementMapper());
    }




}
