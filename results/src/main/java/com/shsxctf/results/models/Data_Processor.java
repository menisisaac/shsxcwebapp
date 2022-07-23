package com.shsxctf.results.models;

import com.shsxctf.results.mappers.EventTestMapper;
import com.shsxctf.results.mappers.RaceTestMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data_Processor {

    public List<String> lines;
    List<String[]> formated = new ArrayList<>();
    private List<String> raceNames;

    private List<List<String>> results;
    private  String eventName;
    private String eventUrl;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    private String season;

    public Data_Processor(String[] line, String eventName, String  eventUrl, String season) {
        lines = Arrays.asList(line);
        this.season = season;
        this.eventName = eventName;
        this.eventUrl = eventUrl;
        getFormattedLines();


    }

    public void format() {
        for (int i = 0; i < lines.size(); i++) {
            if(i != 0) {
                String[] temp = (lines.get(i).split("  "));
                String[] corr = new String[6];
                int count = -1;
                for(int j = 0; j < temp.length; j++) {
                    String temps = temp[j];
                    temp[j] = temp[j].replaceAll("\\s+", "");
                    if(temp[j] != "") {
                        count++;
                        corr[count] = temp[j];
                    }
                    if(count == 2 && temps.replaceAll("\\s+", "") != "" ) {
                        corr[count] = temps.trim();
                    }
                    if(count == 5) {
                        formated.add(corr);
                        break;
                    }
                }

            }
        }



    }

    public void getFormattedLines() {
        List<String> raceNames = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        /*
        State 0: looking for result lines
        State 1: looking for second dotted lines
        State 2: looking for result name
         */
        int state = 0;
        int resultCount = 0;
        for(int i = lines.size() - 1; i > -1; i--) {
            String line = lines.get(i);
            if(state == 0) {
                if(isSchenectady(line)) {
                    results.get(resultCount).add(line);
                } else if(isDotted(line)) {
                    state = 1;
                }
            } else if(state == 1) {
                if(isDotted(line)) {
                    state = 2;
                }
            } else if(isName(line)){
                state = 0;
                raceNames.add(line);
                resultCount++;
                results.add(new ArrayList<>());
            }
        }
        ArrayList<Integer> deletes = new ArrayList<>();
        for(int i = 0; i < raceNames.size(); i++) {
            if(raceNames.get(i).contains("Team") || raceNames.get(i).contains("Merge") || results.get(i).isEmpty()) {
                deletes.add(i);
            }
        }
        int count = 0;
        System.out.println();
        for(Integer i : deletes) {
            raceNames.remove(i - count);
            results.remove(i - count);
            count++;

        }

        this.results = results;
        this.raceNames = raceNames;
    }

    public boolean isSchenectady(String line) {
        if(line.contains("Schenectady")) {
            return true;
        }
        return false;
    }

    public boolean isName(String line) {
        String[] keywords = {"Boys", "Girls", "Varsity", "Frosh", "Team Scores", "Modified"};
        for(String s : keywords) {
            if (line.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDotted(String line) {
        String singleDotted = "-----";
        String doubleDotted = "=======";
        if(line.contains(singleDotted) || line.contains(doubleDotted)) {
            return true;
        }
        return false;
    }


    public List<String> getLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Bad file");
        }
        return new ArrayList<>();
    }

    public List<String[]> getList() {
        return formated;
    }

    public List<String> getRaceNames() {
        return raceNames;
    }

    public void setRaceNames(List<String> raceNames) {
        this.raceNames = raceNames;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }

    public void sendToDataBase(JdbcTemplate template) {

        String sql = "INSERT INTO event_test(name, url, season) VALUES(?,?,?)";
        String raceSQL = "INSERT INTO race_test(idevent, raceName) VALUES(?,?)";
        String resultSQL = "INSERT INTO result_test(description, idevent, idrace) VALUES (?,?,?)";

        template.update(sql, eventName, eventUrl, season);
        int eventid = template.query("SELECT * FROM event_test ORDER BY idevent_test DESC LIMIT 1", new EventTestMapper()).get(0).getId();
        for(int i = 0; i < raceNames.size(); i++) {
            template.update(raceSQL, eventid, raceNames.get(i));
            List<String> tempResult= results.get(i);
            int raceid = template.query("SELECT * FROM race_test ORDER BY idrace_test DESC LIMIT 1", new RaceTestMapper()).get(0).getId();
            for(int j = 0; j < tempResult.size(); j++) {
                String temp = tempResult.get(j);
                template.update(resultSQL, temp, eventid, raceid);
            }



        }

    }
}
