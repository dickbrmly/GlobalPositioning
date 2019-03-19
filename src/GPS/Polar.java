package GPS;

import static java.lang.Math.*;

/**
 * Polar coordinates requires two objects
 * on the earths surface
 */
public class Polar {
  Position here = new Position();
  Position there = new Position();
  Position delta;
  double azimuth;
  double elevation;
  double distance;

  /**
   *
   * @param here location in ECEF
   *
   */
  public Polar(Position here, Position there) {
    this.here.equal(here);
    this.there.equal(there);
    AzimuthElevation(here,there);
  }



  public Polar AzimuthElevation(Position here, Position there) {

    //literal distance on a straight line from one another, not surface distance.
    delta = new Position(new ECEF(there.x - here.x, there.y - here.y, there.z - here.z));
    distance = Math.sqrt(pow(delta.x, 2) + pow(delta.y, 2) + pow(delta.z, 2));
    //component difference


    elevation = Math.asin((there.alt - here.alt) / distance); //more accurate if surface distance is accounted for which
    //lowers there altitude with respect to here.

    azimuth = atan2(Math.sin(there.lon - here.lon) * Math.cos(there.lat), Math.cos(here.lat) * Math.sin(there.lat) - Math.sin(here.lat) * Math.cos(there.lat) * Math.cos(there.lon - here.lon));
    return this;
  }
}
