package com.shsxctf.results.controllers;

import com.shsxctf.results.mappers.EventTestMapper;
import com.shsxctf.results.mappers.RaceTestMapper;
import com.shsxctf.results.mappers.resultsMapper;
import com.shsxctf.results.models.Event;
import com.shsxctf.results.models.Race;
import com.shsxctf.results.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
public class MeetResultController {

    @Autowired
    JdbcTemplate template;

//    @GetMapping("/meet/fullResults/")
    @GetMapping("/meet")
    @CrossOrigin
    List<Event> all() {
        String sql = "SELECT * FROM event_test";
        return template.query(sql, new EventTestMapper());
    }

    @GetMapping("/meet/races")
    @CrossOrigin
    List<Race> getMeetRaces(@RequestParam("eventId") String eventId) {
        String sql = "SELECT * FROM race_test WHERE idevent = " + eventId;
        return template.query(sql, new RaceTestMapper());
    }

    @GetMapping("/race")
    @CrossOrigin
    public List<Result> getResults(@RequestParam("eventId") String eventId, @RequestParam("raceId") String raceId) {
        String sql = "SELECT * FROM result_test WHERE idevent = " + eventId + " and idrace = " + raceId + " ORDER BY idresult_test DESC";
        return template.query(sql, new resultsMapper());
    }
}
