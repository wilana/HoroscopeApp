package Controllers;

import Models.AllSigns;
import Models.Horoscope;
import Models.Sign;
import Utilities.HoroscopeApiUtility;
import Utilities.JSONFileUtility;
import Utilities.SceneChangeUtility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectHoroscopeController implements Initializable {

    private LocalDate today = LocalDate.now();
    private LocalDate yesterday = today.minusDays(1);
    private LocalDate tomorrow = today.plusDays(1);

    private ArrayList<Sign> signs = new ArrayList<>();

    @FXML
    private ComboBox<String> dayComboBox;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private ListView<Sign> signListView;

    @FXML
    private Button getHoroscopeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Find dates


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
            signListView.getItems().addAll(signs);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Start datepicker at 20 years ago
        birthdayDatePicker.setValue(today.minusYears(20));
        // date picker updates list view
        birthdayDatePicker.setOnAction(actionEvent -> {
            LocalDate birthday = birthdayDatePicker.getValue();
            try {
                HoroscopeApiUtility.getSignFromSearch(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth());
                String sign = JSONFileUtility.getSignSearch("./src/JSONFiles/signSearch.json");
                // update list view
                signListView.getItems().clear();
                signListView.getItems().add(getSignInfo(sign));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });


        getHoroscopeButton.setOnAction(event ->
        {
            try {
                getHoroscope(event, signListView.getSelectionModel().getSelectedItem().getName());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });


    }

    private void getHoroscope(ActionEvent event, String sign) throws IOException, InterruptedException {
        String date = "";
        String selected = dayComboBox.getValue();
        if (selected.equalsIgnoreCase(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))) {
            date = "today";
        } else if (selected.equalsIgnoreCase(yesterday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))) {
            date = "yesterday";
        } else if (selected.equalsIgnoreCase(tomorrow.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)))) {
            date = "tomorrow";
        }

        // Get horoscope from API so the controller can find it
        HoroscopeApiUtility.getHoroscopeFromSearch(date, sign);
        // Change scene to view
        SceneChangeUtility.changeScene(event, "/Views/ViewHoroscopeView.fxml", sign + " Horoscope");
    }


    public Sign getSignInfo(String signName) {
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
