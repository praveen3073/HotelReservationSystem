package com.cg.hotelreservation;

public class Hotel {
    public String hotelName;
    public double weekdayRate;
    public double weekendRate;
    public String startDate;
    public String endDate;
    public int rating;
    public double specialWeekdayRate;
    public double specialWeekendRate;

    public Hotel(String hotelName, int weekdayRate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = 0;
        this.startDate = " ";
        this.endDate = " ";
        this.rating = 0;
    }

    public Hotel(String hotelName, double weekdayRate, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = 0;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = 0;
    }

    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate, int rating) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
    }

    public Hotel(String hotelName, double weekdayRate, double weekendRate, String startDate, String endDate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = 0;
    }
}
