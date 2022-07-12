package com.shsxctf.results.models;

public class Result {

    private int id;
    private int raceId;
    private int eventId;
    private String desc;

    public Result(int id, int raceId, int eventId, String desc) {
        this.id = id;
        this.raceId = raceId;
        this.eventId = eventId;
        this.desc = desc;
    }

    public Result() { }

    public Result(int raceId, int eventId, String desc) {
        this.raceId = raceId;
        this.eventId = eventId;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
