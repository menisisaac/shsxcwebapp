package com.shsxctf.results.controllers;

import com.shsxctf.results.mappers.EventTestMapper;
import com.shsxctf.results.mappers.RaceTestMapper;
import com.shsxctf.results.mappers.SeasonMapper;
import com.shsxctf.results.mappers.resultsMapper;
import com.shsxctf.results.models.Event;
import com.shsxctf.results.models.Race;
import com.shsxctf.results.models.Result;
import com.shsxctf.results.models.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.ArrayList;
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

    @GetMapping("/season/xc")
    @CrossOrigin
    List<String> getXcSeason() {
        String sql = "SELECT DISTINCT season FROM event_test";
        List<String> season = template.queryForList(sql, String.class);
        List<String> filteredSeason = new ArrayList<>();
        for(String s : season) {
            if(s.contains("xc") || s.contains("cross country") || s.contains("Cross Country") || s.contains("XC")) {
                filteredSeason.add(s);
            }
        }
        return season;
    }

    @GetMapping("/season/indoor")
    @CrossOrigin
    List<String> getIndoorSeason() {
        String sql = "SELECT DISTINCT season FROM event_test";
        List<String> season = template.queryForList(sql, String.class);
        List<String> filteredSeason = new ArrayList<>();
        for(String s : season) {
            if(s.contains("indoor") || s.contains("Indoor")) {
                filteredSeason.add(s);
            }
        }
        return season;
    }

    @GetMapping("/season/outdoor")
    @CrossOrigin
    List<Season> getOutdoorSeason() {
        String sql = "SELECT DISTINCT season FROM event_test";
        List<Season> season = template.query(sql, new SeasonMapper());
        List<Season> filteredSeason = new ArrayList<>();
        for(Season s : season) {
            if(s.getSeason().contains("Outdoor") || s.getSeason().contains("outdoor")) {
                filteredSeason.add(s);
            }
        }
        return season;
    }

    @GetMapping("/race")
    @CrossOrigin
    public List<Result> getResults(@RequestParam("eventId") String eventId, @RequestParam("raceId") String raceId) {
        String sql = "SELECT * FROM result_test WHERE idevent = " + eventId + " and idrace = " + raceId + " ORDER BY idresult_test DESC";
        return template.query(sql, new resultsMapper());
    }
}
