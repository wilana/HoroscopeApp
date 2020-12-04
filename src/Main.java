import Models.Horoscope;
import Utilities.HoroscopeApiUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/SelectHoroscopeView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        // Add title and show
        stage.setTitle("Horoscope Finder");
        // PNG from https://www.pngrepo.com/svg/217291/astrology-horoscope
        Image ico = new Image("/Images/astrologyIcon.png");
        stage.getIcons().add(ico);
        stage.setScene(scene);
        stage.show();
    }
}


