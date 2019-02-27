package GPS;

/**
 * These are constants based on the earth dealing with
 * the earth defined ellipsoid having a,b,f,e2,er
 */
public class Constants {
  private static Constants Instance = new Constants();
  public Double a = 6378137.0; //Kilometers
  public Double f = 0.00335281066474748071984552861852;
  public Double b = 6356752.3142451794975639665996337;
  public Double e2 = 0.00669437999014133; // = e^2
  public Double er = 0.006739496742276474;
  public Constants() {

  }

  public static Constants getInstance() {
    return Instance;
  }

  public Double RadiusOfCurvature(Double lat) {
    return a / (Math.pow(1.0 - e2 * Math.pow(Math.sin(lat),2), 0.5));
  }

}

