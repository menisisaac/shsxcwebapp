package com.shsxctf.results.models;

public class Race {

    private int id;
    private int eventId;
    private String name;

    public Race(int id, int eventId, String name) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
    }

    public Race(int eventId, String name) {
        this.eventId = eventId;
        this.name = name;
    }

    public Race() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
