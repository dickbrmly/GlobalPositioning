package GPS;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

  private Position location = new Position(34.646033347974 * Math.PI / 180, -86.58610603371206 * Math.PI / 180, 203.0);
  private Position destination = new Position(34.646034347974 * Math.PI / 180,-86.58610603371206 * Math.PI / 180,203.0);
  Polar objective = new Polar(location,destination);

  @FXML private TextField locLat;
  @FXML private TextField locLon;
  @FXML private TextField locAlt;
  @FXML private TextField locX;
  @FXML private TextField locY;
  @FXML private TextField locZ;

  @FXML private TextField destLat;
  @FXML private TextField destLon;
  @FXML private TextField destAlt;
  @FXML private TextField destX;
  @FXML private TextField destY;
  @FXML private TextField destZ;

  @FXML private TextField azimuth;
  @FXML private TextField elevation;

  @FXML private TextField distMeters;
  @FXML private TextField distFeet;
  @FXML private TextField distMiles;

  @FXML
  protected void locUpClick() {

     locLat.setText("This really worked.");
  }

  @FXML
  protected void locDwnClick() {


  }

  @FXML
  protected void destUpClick() {


  }

  @FXML
  protected void destDwnClick() {


  }

  @FXML
  protected void triangulateClick() {


  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {


    locLat.setText(Double.toString(objective.here.lat * 180 / Math.PI));
    locLon.setText(Double.toString(objective.here.lon * 180 / Math.PI));
    locAlt.setText(Double.toString(objective.here.alt));
    locX.setText(Double.toString(objective.here.x));
    locY.setText(Double.toString(objective.here.y));
    locZ.setText(Double.toString(objective.here.z));

    destLat.setText(Double.toString(objective.there.lat * 180 / Math.PI));
    destLon.setText(Double.toString(objective.there.lon * 180 / Math.PI));
    destAlt.setText(Double.toString(objective.there.alt));
    destX.setText(Double.toString(objective.there.x));
    destY.setText(Double.toString(objective.there.y));
    destZ.setText(Double.toString(objective.there.z));

    azimuth.setText(Double.toString(objective.azimuth));
    elevation.setText(Double.toString(objective.elevation));
    distMeters.setText(Double.toString(objective.distance));
  }

}
