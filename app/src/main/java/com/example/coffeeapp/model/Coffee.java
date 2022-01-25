package com.example.coffeeapp.model;

public class Coffee {


    private String title;
    private String image;
    private Double price;
    private int id;

    public Coffee() {
    }

    public Coffee(String title, String image, Double price, int id) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
