package com.shsxctf.results.services;
import com.shsxctf.results.mappers.UrlMapper;
import com.shsxctf.results.models.Data_Processor;
import com.shsxctf.results.models.ResultUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AddOldResults {
    private List<ResultUrl> urls = new ArrayList<>();
    private List<ResultUrl> currentUrls;
    private  Set<String> urlValue = new HashSet<>();
    private String url;
    private String season;

    public AddOldResults(JdbcTemplate template, String url, String season) {
        this.url = url;
        this.season = season;
        scrape(template);
        currentUrls = template.query("SELECT * FROM url", new UrlMapper());
        setUrlValues();
    }

    public void setUrlValues() {
        for (ResultUrl r : currentUrls) {
            urlValue.add(r.getUrl());
        }
    }


    public void scrape(JdbcTemplate template) {
        Document doc;
        String resultUrl = "";
        Elements links;
        try {
            doc = Jsoup.connect(resultUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        links= doc.getElementsByTag("tr");
        for(Element e : links) {
            Elements temp = e.getElementsByTag("td");
            if(temp.size() == 2 && temp.get(1).getElementsByAttribute("href").size() > 0) {
                String tempUrl = temp.get(1).getElementsByAttribute("href").get(0).absUrl("href");
                if(!isUrlIdExists(tempUrl, template)) {
                    if(Scraper.getLines(tempUrl) != null && tempUrl.contains("section2harrier")) {
                        Data_Processor dp = new Data_Processor(Scraper.getLines(tempUrl), temp.get(0).text(), tempUrl, season);
                        dp.sendToDataBase(template);
                    }
                }
            }
        }


    }

    private boolean isUrlIdExists(String url, JdbcTemplate  template) {
        String sql = "SELECT count(*) FROM url WHERE url = ?";
        boolean exists = false;
        int count = template.queryForObject(sql, new Object[] { url }, Integer.class);
        exists = count > 0;
        return exists;
    }

    public List<ResultUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ResultUrl> urls) {
        this.urls = urls;
    }
}
