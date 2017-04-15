package effectiveJava.model;

public class Point {
  private final int x;
  private final int y;
  public Point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }
  //始终要覆盖toString()方法
  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
}
