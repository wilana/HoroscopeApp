import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        stage.setTitle("Horoscope");
        //Image ico = new Image("/Images/seedling.png");
        //stage.getIcons().add(ico);
        stage.setScene(scene);
        stage.show();
    }
}


