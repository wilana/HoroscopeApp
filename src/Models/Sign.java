package Models;

import com.google.gson.annotations.SerializedName;

public class  Sign {
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


    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
        else
            throw new IllegalArgumentException("Name must be longer than 0");
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        String[] date = startDate.split("/");
        this.startDate = formatDate(date);
        }



    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        String[] date = endDate.split("/");
        this.endDate = formatDate(date);
    }

    //
    private String formatDate(String[] date) {
        String month = "";

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
