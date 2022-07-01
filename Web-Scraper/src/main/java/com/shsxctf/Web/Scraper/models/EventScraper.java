package com.shsxctf.Web.Scraper.models;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EventScraper {

    private Event event;
    private List<Race> races = new ArrayList<>();
    private List<WebElement> results;

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public Set<String> getRaceName() {
        return raceName;
    }

    public void setRaceName(Set<String> raceName) {
        this.raceName = raceName;
    }

    private Set<String> raceName = new HashSet<>();
    Resource resource = new ClassPathResource("chromedriver");
    String filePath;
    {
        try {
            filePath = resource.getFile().getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EventScraper(Event event) {
        this.event = event;
    }

    public void raceScraper() {
        System.setProperty("webdriver.chrome.driver", filePath);
        WebDriver driver = new ChromeDriver();
        driver.get(event.getUrl());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
/*        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        WebElement schedule = driver.findElement(By.id("resultsList"));
        List<WebElement> raceHeadings = schedule.findElements(By.tagName("thead"));
        this.results = schedule.findElements(By.tagName("tbody"));
        for (WebElement e : raceHeadings) {
            List<WebElement> temp = e.findElements(By.xpath("./child::*"));
            WebElement nameIdent = temp.get(0).findElements(By.xpath("./child::*")).get(0).findElements(By.xpath("./child::*")).get(0);
            String identifier = nameIdent.getAttribute("name");
            String name = nameIdent.getText();
            List<WebElement> catagories = temp.get(1).findElements(By.xpath("./child::*"));
            Boolean isRelay = true;
            if (catagories.size() > 4) {
                isRelay = false;
            }
            races.add(new Race(event, name, identifier, isRelay));

        }
    }

    public List<WebElement> getResults() {
        return results;
    }

    public void setResults(List<WebElement> results) {
        this.results = results;
    }
}
