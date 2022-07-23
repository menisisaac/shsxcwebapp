package com.shsxctf.results.controllers;

import com.shsxctf.results.mappers.UrlMapper;
import com.shsxctf.results.models.Data_Processor;
import com.shsxctf.results.models.ResultUrl;
import com.shsxctf.results.services.ResultLinkGenerator;
import com.shsxctf.results.services.Scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ResultsController {

    @Autowired
    JdbcTemplate template;

    @CrossOrigin
    @GetMapping("/result/url")
    List<ResultUrl> getUrls() {
        String sql = "SELECT * FROM url";
        return template.query(sql, new UrlMapper());
    }

    @CrossOrigin
    @PostMapping("/result/url")
    void updateUrls() {
        ResultLinkGenerator resultLinkGenerator = new ResultLinkGenerator(template);

    }

    @CrossOrigin
    @PostMapping("/result/urls")
    void test() {
        String[] lines = (Scraper.getLines("https://section2harrier.com/crosscountry21/xc21groutinvy.html"));
        Data_Processor dp = new Data_Processor(lines, "sectional", "google.com", "Outdoor");
        dp.sendToDataBase(template);
    }

}
