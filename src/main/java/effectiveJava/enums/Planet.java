package effectiveJava.enums;

public enum Planet {
  MERCURY(3.30,2.43),
  VENUS(4.86,6.05),
  EARTH(5.97,6.37);
  //声明实例域
  private final double mass;
  private final double redius;
  private final double surfaceGravity;
  private static final double G=6.67300E-11;
  
  private Planet(double mass, double redius) {
    this.mass = mass;
    this.redius = redius;
    surfaceGravity = G*mass/(redius*redius);
  }
  
  public double surfaceWeight(double mass) {
    return mass*surfaceGravity;
  }

  public double getMass() {
    return mass;
  }

  public double getRedius() {
    return redius;
  }

  public double getSurfaceGravity() {
    return surfaceGravity;
  }

}
