package Controllers;

import Models.Sign;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectHoroscopeController implements Initializable {

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
        // populate combobox with today, yesterday, tomorrow

        // populate listview with signs from allSigns.json


    }

    @FXML
    void getHoroscopeButtonClicked(ActionEvent event) {

    }


}
