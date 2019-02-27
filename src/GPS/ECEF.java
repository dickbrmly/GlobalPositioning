package GPS;

class ECEF {
  Double X, Y, Z;

  public ECEF(Double X, Double Y, Double Z) {
    this.X = X;
    this.Y = Y;
    this.Z = Z;
  }

  public ECEF(ECEF ecef) {
    this.X = ecef.X;
    this.Y = ecef.Y;
    this.Z = ecef.Z;
  }

  public LatLon toLatLon() {
    Constants constants = Constants.getInstance();

    Double p = Math.pow(Math.pow(X,2.0) + Math.pow(Y,2.0),0.5);

    Double ang1 = Math.atan((Z * constants.a) / (p * constants.b));

    Double lat = Math.atan ((Z + constants.er * constants.b * Math.pow(Math.sin(ang1),3.0)) /
        (p - constants.e2 * constants.a * Math.pow(Math.cos(ang1),3.0)));
    Double lon = Math.atan (Y/X);

    Double alt = p / Math.cos(lat) - constants.RadiusOfCurvature(lat);

    return new LatLon(lat,lon,alt);
  }// end of toLatLon
}//end of class
