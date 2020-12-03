package Controllers;

import Models.Horoscope;
import Utilities.JSONFileUtility;
import Utilities.SceneChangeUtility;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewHoroscopeController implements Initializable {

        private Horoscope horoscope;

        @FXML
        private Label currentDayLabel;

        @FXML
        private Label descriptionLabel;

        @FXML
        private Label compatibilityLabel;

        @FXML
        private Label moodLabel;


        @FXML
        private Label colourLabel;

        @FXML
        private Label luckyNumLabel;

        @FXML
        private Label luckyTimeLabel;

        @FXML
        private Button goBackButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Horoscope horoscope = JSONFileUtility.getHoroscope("./src/JSONFiles/horoscopeSearch.json");

        descriptionLabel.setWrapText(true);

        // update labels
        currentDayLabel.setText("For " + horoscope.getCurrentDate());
        descriptionLabel.setText(horoscope.getDescription());
        compatibilityLabel.setText(horoscope.getCompatibility());
        moodLabel.setText(horoscope.getMood());
        colourLabel.setText(horoscope.getColour());
        luckyNumLabel.setText(horoscope.getLuckyNum());
        luckyTimeLabel.setText(horoscope.getLuckyTime());

        // Back button changes scene to select horoscope
            goBackButton.setOnAction(event ->
            {
                try {
                        SceneChangeUtility.changeScene(event, "/Views/SelectHoroscopeView.fxml", "Pick Horoscope");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        });
    }

}
