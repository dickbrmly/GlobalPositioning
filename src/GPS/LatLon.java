package GPS;

public class LatLon {
  Double lat,lon,alt;

  public LatLon(Double lat, Double lon, Double alt) {
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
  }

  public LatLon(Double lat, Double lon) {
    this.lat = lat;
    this.lon = lon;
    this.alt = 0.0;
  }

  public LatLon(LatLon latlon) {
    this.lat = latlon.lat;
    this.lon = latlon.lon;
    this.alt = latlon.alt;
  }

  public ECEF toECEF() {
    Constants constants = Constants.getInstance();
    Double N = constants.RadiusOfCurvature(lat);

    return new ECEF((N + alt) * Math.cos(this.lat) * Math.cos(this.lon),(N + alt) * Math.cos(this.lat) * Math.sin(this.lon),
        ((Math.pow(constants.b,2) / Math.pow(constants.a,2) * N + alt) * Math.sin(this.lat)));
  }
}
