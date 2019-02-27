package GPS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Double lat = 34.765386 * Math.PI / 180;
        Double lon = -86.657352 * Math.PI / 180;
        Double alt = 263.0;

        Double X = 305852.0;
        Double Y = -5236.604;
        Double Z = 3616.666;

        LatLon latlon = new LatLon(lat ,lon, alt);
        ECEF ecef = new ECEF(latlon.toECEF());
        LatLon latlon2 = new LatLon(ecef.toLatLon());

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
