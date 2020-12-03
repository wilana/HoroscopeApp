package Controllers;

import Models.Horoscope;
import Utilities.JSONFileUtility;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewHoroscopeController implements Initializable {

        private Horoscope horoscope;

        @FXML
        private Label currentDayLabel;

        @FXML
        private Label currentDayLabel1;

        @FXML
        private Label signLabel;

        @FXML
        private Label dateRangeLabel;

        @FXML
        private Label currentDayLabel11;

        @FXML
        private Label descriptionLabel;

        @FXML
        private Label currentDayLabel12;

        @FXML
        private Label compatibilityLabel;

        @FXML
        private Label currentDayLabel122;

        @FXML
        private Label moodLabel;

        @FXML
        private Label currentDayLabel121;

        @FXML
        private Label colourLabel;

        @FXML
        private Label currentDayLabel1221;

        @FXML
        private Label luckyNumLabel;

        @FXML
        private Label currentDayLabel1211;

        @FXML
        private Label luckyTimeLabel;

        @FXML
        private Button goBackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void goBackButtonPushed(ActionEvent event) {

    }

    public void initData(String sign) {
            horoscope = JSONFileUtility.getHoroscope("./src/JSONFiles/horoscopeSearch.json");

    }
}
