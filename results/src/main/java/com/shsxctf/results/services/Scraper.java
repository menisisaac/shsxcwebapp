package com.shsxctf.results.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class Scraper {

    public static String[] getLines(String url) {
        try {
            String text = "";
            Document doc = Jsoup.connect("http://section2harrier.com").get();
            try {
                doc = Jsoup.connect(url).get();
                text = doc.text();
            } catch (Exception  e) {
                return null;
            }
            String[] lines = text.split("\r?\n|\r");
            if(hasSchenectady(text)) {
                return lines;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;

        }

    }

    public static boolean hasSchenectady(String text) {
        for(String s : text.split(" ")) {
            if(s.equals("Schenectady")) {
                return true;
            }
        }
        return false;
    }

}
