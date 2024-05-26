package com.coverdev.vstore.Models;

public class Article {
    private int imageResId;
    private String title;
    private String body;

    public Article(int imageResId, String title, String body) {
        this.imageResId = imageResId;
        this.title = title;
        this.body = body;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
