package com.shsxctf.results.services;
import com.shsxctf.results.models.ResultUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ResultLinkGenerator {
    private List<ResultUrl> urls = new ArrayList<>();

    private final String url = "https://www.section2harrier.com/";

    public ResultLinkGenerator(JdbcTemplate template) {
        scrape(template);
    }


    public void scrape(JdbcTemplate template) {
        Document doc;
        String sql = "INSERT INTO url (url, name) VALUES (?, ?)";
        String resultUrl = "";
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements links = doc.getElementsByAttribute("href");
        for(Element e : links) {
            if(e.text().equals("Invitationals & Results")) {
                System.out.println(e.absUrl("href"));
                resultUrl = e.absUrl("href");
                break;
            }
        }
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
                template.update(sql, tempUrl, temp.get(0).text());
                urls.add(new ResultUrl(tempUrl, temp.get(0).text()));
            }
        }


    }

    public List<ResultUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ResultUrl> urls) {
        this.urls = urls;
    }
}
