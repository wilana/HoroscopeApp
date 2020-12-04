package Models;

import com.google.gson.annotations.SerializedName;

public class Sign {
    @SerializedName("name")
    private String name;

    @SerializedName("start_date")
    private String startDate;

    @SerializedName("end_date")
    private String endDate;

    public Sign(String name, String startDate, String endDate) {
        setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public String getName() {
        return name;
    }

    /**
     * Name cannot be empty
     *
     * @param name name of sign
     */
    public void setName(String name) {
        if (!name.isBlank())
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be longer than 0");
    }

    public String getStartDate() {
        return startDate;
    }

    /**
     * Date should be in DD/MM form where it can be formatted
     * or a copy of a previously formatted date
     *
     * @param startDate DD/MM date
     */
    public void setStartDate(String startDate) {
        if (!startDate.isBlank()) {
            if (startDate.contains("/")) {
                // Split using /
                String[] date = startDate.split("/");
                // this method decides whether to format or not
                this.startDate = formatDate(date);
            } else
                this.startDate = startDate;
        } else
            throw new IllegalArgumentException("Must include start date");
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (!endDate.isBlank()) {
            if (endDate.contains("/")) {
                // Split using /
                String[] date = endDate.split("/");
                // this method decides whether to format or not
                this.endDate = formatDate(date);
            } else
                this.endDate = endDate;
        } else
            throw new IllegalArgumentException("Must include end date");
    }


    @Override
    public String toString() {
        return name + "(" + startDate + " - " + endDate + ")";
    }

    /**
     * Format date as 3 letter month followed by day
     *
     * @param date Split string array of date
     * @return formatted date
     */
    private String formatDate(String[] date) {

        String month;

        // file has form 22/1 for day/month
        if (date[1].equalsIgnoreCase("1"))
            month = "Jan";
        else if (date[1].equalsIgnoreCase("2"))
            month = "Feb";
        else if (date[1].equalsIgnoreCase("3"))
            month = "Mar";
        else if (date[1].equalsIgnoreCase("4"))
            month = "Apr";
        else if (date[1].equalsIgnoreCase("5"))
            month = "May";
        else if (date[1].equalsIgnoreCase("6"))
            month = "Jun";
        else if (date[1].equalsIgnoreCase("7"))
            month = "Jul";
        else if (date[1].equalsIgnoreCase("8"))
            month = "Aug";
        else if (date[1].equalsIgnoreCase("9"))
            month = "Sep";
        else if (date[1].equalsIgnoreCase("10"))
            month = "Oct";
        else if (date[1].equalsIgnoreCase("11"))
            month = "Nov";
        else
            month = "Dec";

        return String.format("%s %s", month, date[0]);


    }
}
