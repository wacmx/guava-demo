package effectiveJava.t04;

/**
 * 类层次优于标签类
 * @author Yangyang
 *
 */
abstract class Demo20 {
  abstract double area();
}

class Circle  extends Demo20 {
  final double radius;

  public Circle(double radius) {
    super();
    this.radius = radius;
  }
  
  double area(){
    return Math.PI*(radius*radius);
  }
}

class Rectangle  extends Demo20 {
  final double len;
  final double wid;

  public Rectangle(double len, double wid) {
    super();
    this.len = len;
    this.wid = wid;
  }

  double area(){
    return len*wid;
  }
}

