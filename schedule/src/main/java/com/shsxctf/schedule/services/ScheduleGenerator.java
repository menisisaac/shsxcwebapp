package com.shsxctf.schedule.services;

import com.shsxctf.schedule.models.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ScheduleGenerator {
    private Set<Event> events = new HashSet<>();
    private final String url = "https://ny.milesplit.com/teams/11663-schenectady";
    Resource resource = new ClassPathResource("chromedriver");
    String filePath;
    {
        try {
            filePath = resource.getFile().getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ScheduleGenerator() {
    }

    public void scrapeSchedule () {
        System.setProperty("webdriver.chrome.driver", filePath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement schedule = driver.findElement(By.id("schedule"));
        List<WebElement> list = schedule.findElements(By.xpath("./child::*"));
        String name = "";
        int i = 0;
        for (WebElement l : list) {
            List<WebElement> temp = l.findElements(By.xpath("./child::*"));
            String date = temp.get(0).getText();
            List<WebElement> subtemp = temp.get(1).findElements(By.xpath("./child::*"));
            if (subtemp.get(0).getText() == "") {
                name = subtemp.get(1).getText();
            } else {
                name = subtemp.get(0).getText();
            }
            String location = temp.get(2).getText();
            subtemp = temp.get(3).findElements(By.xpath("./child::*"));
            if (subtemp.isEmpty()) {
                continue;
            }
            String result = subtemp.get(0).getAttribute("href");
            events.add(new Event(name, location, date));
            i++;
        }
    }

    public Set<Event> getEvents() {
        return events;
    }


}
