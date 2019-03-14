package GPS;

class ECEF {
  double x, y, z,magnetude;

  public ECEF() {};

  public ECEF(Double x, Double y, Double z) {
    this.x = x;
    this.y = y;
    this.z = z;

    this.magnetude = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2); //  ||v||
  }

  public ECEF(ECEF ecef) {
    this.x = ecef.x;
    this.y = ecef.y;
    this.z = ecef.z;

    this.magnetude = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2); //  ||v||
  }

  public ECEF(Position that) {
    this.x = that.x;
    this.y = that.y;
    this.z = that.z;

    this.magnetude = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2); //  ||v||
  }



}//end of class
