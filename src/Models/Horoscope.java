package Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Horoscope {
    @SerializedName("date_range")
    private String dateRange;

    @SerializedName("current_date")
    private String currentDate;

    @SerializedName("description")
    private String description;

    @SerializedName("compatibility")
    private String compatibility;

    @SerializedName("mood")
    private String mood;

    @SerializedName("color")
    private String colour;

    @SerializedName("lucky_number")
    private String luckyNum;

    @SerializedName("lucky_time")
    private String luckyTime;

    public Horoscope(String dateRange, String currentDate, String description, String compatibility,
                     String mood, String colour, String luckyNum, String luckyTime)
    {
        setCurrentDate(currentDate);
        setDateRange(dateRange);
        setDescription(description);
        setCompatibility(compatibility);
        setMood(mood);
        setColour(colour);
        setLuckyTime(luckyTime);
        setLuckyNum(luckyNum);
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLuckyTime() {
        return luckyTime;
    }

    public void setLuckyTime(String luckyTime) {
        this.luckyTime = luckyTime;
    }

    public String getLuckyNum() {
        return luckyNum;
    }

    public void setLuckyNum(String luckyNum) {
        this.luckyNum = luckyNum;
    }
}
