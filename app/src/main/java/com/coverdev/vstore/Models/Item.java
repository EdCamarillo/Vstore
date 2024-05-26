package com.coverdev.vstore.Models;

public class Item {
    private int photo;
    private String name;
    private String price;

    public Item(int photo, String name, String price) {
        this.photo = photo;
        this.name = name;
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

