package com.ebc.gaweeeandroidapps.model;

public class ReportTable {

    private String date;
    private String checkIn;
    private String checkOut;

    public ReportTable(String date, String checkIn, String checkOut) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

}
