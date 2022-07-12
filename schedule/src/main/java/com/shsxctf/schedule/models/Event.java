package com.shsxctf.schedule.models;

import java.sql.Date;
import java.util.Comparator;

public class Event implements Comparable<Event> {
    private int id;
    private String name;
    private String location;
    private String date;

    public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public Event(int id, String name, String location, String date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public Event() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        return date != null ? date.equals(event.date) : event.date == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Event o) {

        String[] first = this.getDate().split("/");
        String[] second = this.getDate().split("/");
        Integer firstInt = Integer.valueOf(first[0]) * 30 + Integer.valueOf(first[1]);
        Integer secondInt = Integer.valueOf(second[0]) * 30 + Integer.valueOf(second[1]);
        return firstInt.compareTo(secondInt);
    }
}
