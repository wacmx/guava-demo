package effectiveJava.t04;
/**
 * 不可变类:使可变性最小化
 * 1.不提供修改对象状态的方法
 * 2.保证类不会被扩展
 * 3.域都是final
 * 4.域都是私有
 * 5.对任何可变组件互斥
 * 
 * 例如:TimeTask接口
 * @author Yangyang
 *
 */
public final class Demo14 {
  private final Double re;
  private final Double im;
  private Demo14(Double re, Double im) {
    super();
    this.re = re;
    this.im = im;
  }
  //构造器私有,静态工厂替代构造器
  public static Demo14 valueOf(Double re,Double im){
    return new Demo14(re,im);
  }
  public static Demo14 valueOfPolar(Double r,Double theta){
    return new Demo14(r*Math.cos(r),r*Math.sin(theta));
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((im == null) ? 0 : im.hashCode());
    result = prime * result + ((re == null) ? 0 : re.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Demo14 other = (Demo14) obj;
    if (im == null) {
      if (other.im != null)
        return false;
    } else if (!im.equals(other.im))
      return false;
    if (re == null) {
      if (other.re != null)
        return false;
    } else if (!re.equals(other.re))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "(" + re + " + " + im + "i)";
  }
  
}
