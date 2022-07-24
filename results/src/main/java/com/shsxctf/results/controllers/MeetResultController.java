package com.shsxctf.results.controllers;

import com.shsxctf.results.mappers.EventTestMapper;
import com.shsxctf.results.mappers.RaceTestMapper;
import com.shsxctf.results.mappers.SeasonMapper;
import com.shsxctf.results.mappers.resultsMapper;
import com.shsxctf.results.models.Event;
import com.shsxctf.results.models.Race;
import com.shsxctf.results.models.Result;
import com.shsxctf.results.models.Season;
import com.shsxctf.results.services.AddOldResults;
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

    @GetMapping("/meet/outdoor/season")
    @CrossOrigin
    List<Event> outdoor(@RequestParam("sea") String sea) {
        String sql = "SELECT * FROM event_test WHERE season = " + "'" +  sea + "'";
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
    List<Season> getXcSeason() {
        String sql = "SELECT DISTINCT season FROM event_test";
        List<Season> season = template.query(sql, new SeasonMapper());
        List<Season> filteredSeason = new ArrayList<>();
        for(Season s : season) {
            if(s.getSeason().contains("xc") || s.getSeason().contains("cross") || s.getSeason().contains("Cross") || s.getSeason().contains("XC")) {
                filteredSeason.add(s);
            }
        }
        return filteredSeason;
    }

    @GetMapping("/season/indoor")
    @CrossOrigin
    List<Season> getIndoorSeason() {
        String sql = "SELECT DISTINCT season FROM event_test";
        List<Season> season = template.query(sql, new SeasonMapper());
        List<Season> filteredSeason = new ArrayList<>();
        for(Season s : season) {
            if(s.getSeason().contains("indoor") || s.getSeason().contains("Indoor")) {
                filteredSeason.add(s);
            }
        }
        return filteredSeason;
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
        return filteredSeason;
    }

    @PostMapping("/addResult")
    @CrossOrigin
    public void addResults() {
        AddOldResults results = new AddOldResults(template, "https://www.section2harrier.com/indoor2122/in2122schedule.html", "2021-22 Indoor");
        AddOldResults resultsTwo = new AddOldResults(template, "https://section2harrier.com/crosscountry21/xc21invy.html", "2021 Cross Country");
    }

    @GetMapping("/race")
    @CrossOrigin
    public List<Result> getResults(@RequestParam("eventId") String eventId, @RequestParam("raceId") String raceId) {
        String sql = "SELECT * FROM result_test WHERE idevent = " + eventId + " and idrace = " + raceId + " ORDER BY idresult_test DESC";
        return template.query(sql, new resultsMapper());
    }
}
