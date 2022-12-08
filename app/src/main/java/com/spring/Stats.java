package com.spring;

public class Stats {

    private String score;
    private String name;
    private String img;

    public Stats(String score, String name, String img) {
        this.score = score;
        this.name = name;
        this.img = img;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return "https:/"+img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
