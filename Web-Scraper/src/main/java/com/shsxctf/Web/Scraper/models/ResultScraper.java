package com.shsxctf.Web.Scraper.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultScraper {

    private List<WebElement> results;
    private List<Result> parsedResults = new ArrayList<>();
    private List<Race> races;

    public ResultScraper(List<Race> races, List<WebElement> results) {
        this.races = races;
        this.results = results;
    }

    public void parseResults() {
        for (int i = 0; i < results.size(); i++) {
            Race currRace = races.get(i);
            if (currRace.isRelay()) {
                parseRelay(currRace, results.get(i));
            } else {
                parseIndividual(currRace, results.get(i));
            }
        }
    }

    public void parseRelay(Race race, WebElement element) {
        List<WebElement> teams = element.findElements(By.xpath("./child::*"));
        for (WebElement e : teams) {
            List<WebElement> elements = e.findElements(By.xpath("./child::*"));
            String place = elements.get(0).getAttribute("data-text");
            String teamName = elements.get(1).findElements(By.xpath("./child::*")).get(0).getText();
            String time = elements.get(2).getAttribute("data-text");
            String heat = elements.get(3).getAttribute("data-text");
            race.getResults().add(new Result(race, time, place, heat, teamName));
        }
    }
    public void parseIndividual(Race race, WebElement element) {
        List<WebElement> teams = element.findElements(By.xpath("./child::*"));
        for (WebElement e : teams) {
            List<WebElement> elements = e.findElements(By.xpath("./child::*"));
            String place = elements.get(0).getAttribute("data-text");
            String athlete = elements.get(1).findElements(By.xpath("./child::*")).get(0).getText();
            String grade = elements.get(2).getAttribute("data-text");
            String teamName= elements.get(3).findElements(By.xpath("./child::*")).get(0).getText();
            String time = elements.get(4).getAttribute("data-text");
            String heat = elements.get(6).getAttribute("data-text");
            race.getResults().add(new IndividualResult(race, time, place, heat, teamName, athlete, athlete, grade));
        }
    }
}
