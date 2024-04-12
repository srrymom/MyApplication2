package com.example.myapplication;

public class Book {
    int cover;
    String title;
    String date;
    String place;

    public Book(int cover, String title, String date, String place) {
        this.cover = cover;
        this.title = title;
        this.date = date;
        this.place = place;
    }

    public int getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }
}
