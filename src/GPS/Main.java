package GPS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Double lat = 34.7303688 * Math.PI / 180;
        Double lon = -86.5861037 * Math.PI / 180;
        Double alt = 183.0;

        Double X = 312491.0;
        Double Y = -5238364.0;
        Double Z = 3613428.0;

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
