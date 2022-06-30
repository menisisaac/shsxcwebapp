package com.shsxctf.Web.Scraper.models;

public class Result {

    private Long id;
    private Race race;
    private String time;
    private String place;
    private String heat;
    private String team;

    public Result(Race race, String time, String place, String heat, String team) {
        this.race = race;
        this.time = time;
        this.place = place;
        this.heat = heat;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Result{" +
                "time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", heat='" + heat + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
