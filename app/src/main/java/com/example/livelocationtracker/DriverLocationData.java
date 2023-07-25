package com.example.livelocationtracker;



public class DriverLocationData {

    String busNo,locationUrl;

    public DriverLocationData() {
        // Default constructor required for Firebase Realtime Database
    }

    public DriverLocationData(String busNo, String locationUrl) {
        this.busNo = busNo;
        this.locationUrl = locationUrl;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }
}

