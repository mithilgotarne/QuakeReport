package com.example.mithil.quakereport;

/**
 * Created by Mithil on 12/6/2016.
 */

public class Earthquake {
    private double magnitude;
    private String place;
    private Long timeInMilliSeconds;
    private String url;

    public Earthquake(double magnitude, String place, Long timeInMilliSeconds, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMilliSeconds = timeInMilliSeconds;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public Long getTimeInMilliSeconds() {
        return timeInMilliSeconds;
    }
}
