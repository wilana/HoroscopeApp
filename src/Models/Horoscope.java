package Models;

import java.util.Date;

public class Horoscope {
    private Date currentDate;
    private String dateRange, description, compatibility, mood, color, luckyTime;
    private int luckyNum;

    public Horoscope(Date currentDate, String dateRange, String description, String compatibility, String mood, String color, String luckyTime, int luckyNum) {
        setCurrentDate(currentDate);
        setDateRange(dateRange);
        setDescription(description);
        setCompatibility(compatibility);
        setMood(mood);
        setColor(color);
        setLuckyTime(luckyTime);
        setLuckyNum(luckyNum);
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLuckyTime() {
        return luckyTime;
    }

    public void setLuckyTime(String luckyTime) {
        this.luckyTime = luckyTime;
    }

    public int getLuckyNum() {
        return luckyNum;
    }

    public void setLuckyNum(int luckyNum) {
        this.luckyNum = luckyNum;
    }
}
