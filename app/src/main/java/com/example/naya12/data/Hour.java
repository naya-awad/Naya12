package com.example.naya12.data;

public class Hour
{
    private String hour;
    private String minutes;

    public Hour(String hour, String minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return this.hour+":"+this.minutes;
    }
}
