package GPS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Position here = new Position(34.646033347974 * Math.PI / 180, -86.58610603371206 * Math.PI / 180, 203.0);
        Position there = new Position(34.646033347974 * Math.PI / 180,-86.58610603371206 * Math.PI / 180,203.0);

        Polar going = new Polar(here, there);

        Parent root = FXMLLoader.load(getClass().getResource("Positons.fxml"));
        primaryStage.setTitle("Positions Calculator");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
