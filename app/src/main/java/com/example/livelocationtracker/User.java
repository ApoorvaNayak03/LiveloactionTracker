package com.example.livelocationtracker;

public class User {
    private String busNumber,locationLink;

    public User(String busNumber) {
    }

    public User(String busNumber, String locationLink) {
        this.busNumber = busNumber;
        this.locationLink = locationLink;
    }


    public String getUserId() {
        return "url";
    }
}
