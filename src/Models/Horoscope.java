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
                     String mood, String colour, String luckyNum, String luckyTime) {
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

    /**
     * Current Date can't be empty
     *
     * @param currentDate date of horoscope
     */
    public void setCurrentDate(String currentDate) {
        if (!currentDate.isBlank())
            this.currentDate = currentDate;
        else
            throw new IllegalArgumentException("Must have current date");
    }

    public String getDateRange() {
        return dateRange;
    }

    /**
     * Date Range can't be empty
     *
     * @param dateRange birthday range for sign
     */
    public void setDateRange(String dateRange) {
        if (!dateRange.isBlank())
            this.dateRange = dateRange;
        else
            throw new IllegalArgumentException("Must have date range");
    }

    public String getDescription() {
        return description;
    }

    /**
     * Description can't be empty
     *
     * @param description horoscope details
     */
    public void setDescription(String description) {
        if (!description.isBlank())
            this.description = description;
        else
            throw new IllegalArgumentException("Must have description");
    }

    public String getCompatibility() {
        return compatibility;
    }

    /**
     * Compatibility cannot be empty
     *
     * @param compatibility a compatible sign
     */
    public void setCompatibility(String compatibility) {
        if (!compatibility.isBlank())
            this.compatibility = compatibility;
        else
            throw new IllegalArgumentException("Must have compatible sign");

    }

    public String getMood() {
        return mood;
    }

    /**
     * Mood cannot be empty
     *
     * @param mood daily mood
     */
    public void setMood(String mood) {
        if (!mood.isBlank())
            this.mood = mood;
        else
            throw new IllegalArgumentException("Must have mood");

    }

    public String getColour() {
        return colour;
    }

    /**
     * Colour cannot be empty
     *
     * @param colour daily colour
     */
    public void setColour(String colour) {
        if (!colour.isBlank())
            this.colour = colour;
        else
            throw new IllegalArgumentException("Must have colour");

    }

    public String getLuckyTime() {
        return luckyTime;
    }

    /**
     * Lucky Time of Day cannot be empty
     *
     * @param luckyTime lucky time of day
     */
    public void setLuckyTime(String luckyTime) {
        if (!luckyTime.isBlank())
            this.luckyTime = luckyTime;
        else
            throw new IllegalArgumentException("Must have lucky time of day");

    }

    public String getLuckyNum() {
        return luckyNum;
    }

    /**
     * Lucky number cannot be empty
     *
     * @param luckyNum daily lucky number
     */
    public void setLuckyNum(String luckyNum) {
        if (!luckyNum.isBlank())
            this.luckyNum = luckyNum;
        else
            throw new IllegalArgumentException("Must have lucky number");
    }
}
