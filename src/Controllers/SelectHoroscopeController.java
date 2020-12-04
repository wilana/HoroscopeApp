package Controllers;

import Models.Sign;
import Utilities.HoroscopeApiUtility;
import Utilities.JSONFileUtility;
import Utilities.SceneChangeUtility;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectHoroscopeController implements Initializable {

    // Current dates
    private LocalDate today = LocalDate.now();
    private LocalDate yesterday = today.minusDays(1);
    private LocalDate tomorrow = today.plusDays(1);
    // store all signs
    private ArrayList<Sign> signs = new ArrayList<>();

    @FXML
    private ComboBox<String> dayComboBox;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private ListView<Sign> signListView;

    @FXML
    private  Button allSignsButton;

    @FXML
    private Button getHoroscopeButton;

    /**
     * Start scene with current dates and list of all signs
     * and listener for birthday datepicker and get horoscope button
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // make allSignsButton not visible
        allSignsButton.setVisible(false);

        // formatting from https://howtodoinjava.com/java/date-time/localdate-format-example/
        String todayDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String yesterdayDate = yesterday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String tomorrowDate = tomorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));

        // populate combobox with today, yesterday, tomorrow
        dayComboBox.getItems().addAll(yesterdayDate, todayDate, tomorrowDate);
        dayComboBox.setValue(todayDate);

        // populate listview with signs from allSigns.json
        try {
            // clear list view
            signListView.getItems().clear();
            // create json file
            HoroscopeApiUtility.getAllSigns();
            // use json utility to file out list view
            signs = JSONFileUtility.getSignList("./src/JSONFiles/allSigns.json");
            // update list view to see all signs
            signListView.getItems().addAll(signs);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // if All Signs button is clicked, show all signs and hide button
        allSignsButton.setOnAction(event ->
        {
            signListView.getItems().clear();
            signListView.getItems().addAll(signs);
            // hide button again
            allSignsButton.setVisible(false);
        });

        // Start datepicker at 20 years ago
        birthdayDatePicker.setValue(today.minusYears(20));

        // date picker updates list view when a date is chosen
        birthdayDatePicker.setOnAction(actionEvent -> {
            LocalDate birthday = birthdayDatePicker.getValue();
            try {
                HoroscopeApiUtility.getSignFromSearch(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth());
                String sign = JSONFileUtility.getSignSearch("./src/JSONFiles/signSearch.json");
                // update list view
                signListView.getItems().clear();
                signListView.getItems().add(getSignInfo(sign));

                // show button to see all
                allSignsButton.setVisible(true);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Get Horoscope Button clicked
        getHoroscopeButton.setOnAction(event ->
        {
            try {
                String sign = signListView.getSelectionModel().getSelectedItem().getName();
                if (!sign.equalsIgnoreCase("Invalid Date")) {
                    String date;
                    String selected = dayComboBox.getValue();
                    if (selected.equalsIgnoreCase(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))) {
                        date = "today";
                    } else if (selected.equalsIgnoreCase(yesterday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))) {
                        date = "yesterday";
                    } else {
                        date = "tomorrow";
                    }

                    // Get horoscope from API so the controller can find it
                    HoroscopeApiUtility.getHoroscopeFromSearch(date, sign);
                    // Change scene to view
                    SceneChangeUtility.changeScene(event, "/Views/ViewHoroscopeView.fxml", sign + " Horoscope");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException nullPointerException) {
                signListView.getItems().clear();
                signListView.getItems().addAll(signs);

            }
        });

    }

    /**
     * Finds matching sign to add dates to sign name from JSON
     * Used after getting sign from datepicker
     *
     * @param signName sign to find
     * @return Sign object with name and dates
     */
    private Sign getSignInfo(String signName) {
        // Set default sign
        Sign matchingSign = new Sign(signName, "00/00", "00/00");

        for (Sign sign : signs) {
            if (sign.getName().equalsIgnoreCase(signName)) {
                // if they match set dates
                matchingSign.setStartDate(sign.getStartDate());
                matchingSign.setEndDate(sign.getEndDate());
            }
        }

        return matchingSign;
    }
}