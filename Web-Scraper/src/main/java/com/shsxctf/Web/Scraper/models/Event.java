package com.shsxctf.Web.Scraper.models;

import java.util.HashSet;
import java.util.Set;

public class Event {

    private Long id;
    private String name;
    private String location;
    private String date;
    private Set<Race> races = new HashSet<>();
    private String url;

    public Event(String name, String location, String date, String url) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public void setRaces(Set<Race> races) {
        this.races = races;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", races=" + races +
                ", url='" + url + '\'' +
                '}';
    }
}
