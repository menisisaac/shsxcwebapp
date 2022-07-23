package com.shsxctf.results.models;

public class Event {
    private int id;
    private String name;
    private String season;


    public Event(int id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
    }

    public Event() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String date) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
