package com.shsxctf.Web.Scraper.models;

import java.util.List;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        //ScheduleScraper ms = new ScheduleScraper();
        //ms.scrapeSchedule();
        Event e = new Event("BotiBoy", "Home", "06/30/01", "https://ny.milesplit.com/meets/478827/results");
        EventScraper r = new EventScraper(e);
        r.raceScraper();
        List<Race> names = r.getRaces();

        ResultScraper es = new ResultScraper(names, r.getResults());
        es.parseResults();
        for (Race i : names) {
            System.out.println(i);
        }
    }
}
