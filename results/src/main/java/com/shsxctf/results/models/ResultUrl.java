package com.shsxctf.results.models;

public class ResultUrl {

    private int id;
    private String url;
    private String name;

    public ResultUrl(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public ResultUrl() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResultUrl{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
