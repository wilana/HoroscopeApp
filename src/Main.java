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

        try {
            HoroscopeApiUtility.getSignFromSearch("1995","05","11");
            HoroscopeApiUtility.getHoroscopeFromSearch("today", "taurus");
            HoroscopeApiUtility.getAllSigns();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/SelectHoroscopeView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("styles.css");
        // Add title and show
        stage.setTitle("Horoscope");
        //Image ico = new Image("/Images/seedling.png");
        //stage.getIcons().add(ico);
        stage.setScene(scene);
        stage.show();
    }
}


