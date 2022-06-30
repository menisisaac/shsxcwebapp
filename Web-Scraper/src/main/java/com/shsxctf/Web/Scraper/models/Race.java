package com.shsxctf.Web.Scraper.models;

import java.util.HashSet;
import java.util.Set;

public class Race {

    private Long id;
    private Event event;
    private String raceName;
    private String symbol;
    private boolean isRelay;
    private Set<Result> results = new HashSet<>();

    public Race(Event event, String raceName, String symbol, boolean isRelay) {
        this.event = event;
        this.raceName = raceName;
        this.symbol = symbol;
        this.isRelay = isRelay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public boolean isRelay() {
        return isRelay;
    }

    public void setRelay(boolean relay) {
        isRelay = relay;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Race{" +
                "event=" + event +
                ", raceName='" + raceName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", isRelay=" + isRelay +
                ", results=" + results +
                '}';
    }
}
