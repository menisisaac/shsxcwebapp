package com.shsxctf.results.controllers;

import com.shsxctf.results.mappers.RaceTestMapper;
import com.shsxctf.results.models.Race;
import com.shsxctf.results.models.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class LiveResultController {

    @GetMapping("live/race")
    @CrossOrigin
    public Set<Race> getRaces() {
        //Return races with complete results
        return new HashSet<>();
    }

    @GetMapping("live/result")
    @CrossOrigin
    public Set<Result> getResult(@RequestParam("raceId") String raceId) {
        //Return results for each race
        return  new HashSet<>();
    }


    @PostMapping("/upload")
    @CrossOrigin
    public void uploadFile() {
        //Take in hytek track meet result files and parse them adding them to the live results database
    }
}
