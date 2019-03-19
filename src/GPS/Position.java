package GPS;

import javafx.geometry.Pos;

public class Position {

  Constants constants = Constants.getInstance();

  public double lat, lon, alt, x, y, z,magnitude;

  public Position() {};

  public Position(ECEF there) {
    this.x = there.x;
    this.y = there.y;
    this.z = there.z;

    Double p = Math.pow(Math.pow(x,2.0) + Math.pow(y,2.0),0.5);
    Double ang1 = Math.atan((z * constants.a) / (p * constants.b));
    lat = Math.atan ((z + constants.er * constants.b * Math.pow(Math.sin(ang1),3.0)) /
        (p - constants.e2 * constants.a * Math.pow(Math.cos(ang1),3.0)));
    lon = Math.atan (y/x);
    alt = p / Math.cos(lat) - constants.RadiusOfCurvature(lat);
  }

  public Position(LatLon there) {
    this.lat = there.lat;
    this.lon = there.lon;
    this.alt = there.alt;

    double N = constants.RadiusOfCurvature(lat);
    this.x = (N + alt) * Math.cos(this.lat) * Math.cos(this.lon);
    this.y = (N + alt) * Math.cos(this.lat) * Math.sin(this.lon);
    this.z = ((Math.pow(constants.b,2) / Math.pow(constants.a,2) * N + alt) * Math.sin(this.lat));
  }

  public Position(double lat,double lon,double alt) {
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;

    double N = constants.RadiusOfCurvature(lat);
    this.x = (N + alt) * Math.cos(this.lat) * Math.cos(this.lon);
    this.y = (N + alt) * Math.cos(this.lat) * Math.sin(this.lon);
    this.z = ((Math.pow(constants.b,2) / Math.pow(constants.a,2) * N + alt) * Math.sin(this.lat));
  }

  public Position(double x, double y, double z,double magnitude) {
    this.lat = x;
    this.lat = y;
    this.lat = z;
    this.magnitude = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2);

    Double p = Math.pow(Math.pow(x,2.0) + Math.pow(y,2.0),0.5);
    Double ang1 = Math.atan((z * constants.a) / (p * constants.b));
    lat = Math.atan ((z + constants.er * constants.b * Math.pow(Math.sin(ang1),3.0)) /
        (p - constants.e2 * constants.a * Math.pow(Math.cos(ang1),3.0)));
    lon = Math.atan (y/x);
    alt = p / Math.cos(lat) - constants.RadiusOfCurvature(lat);
  }


  public void equal(Position that) {
    this.lon = that.lon;
    this.lat = that.lat;
    this.x = that.x;
    this.y = that.y;
    this.z = that.z;
    this.alt = that.alt;

    this.magnitude = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2);
  }
}
