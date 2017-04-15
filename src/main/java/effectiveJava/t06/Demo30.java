package effectiveJava.t06;

import static effectiveJava.enums.Planet.*;

import effectiveJava.enums.Operation;
import effectiveJava.enums.Planet;

/**
 * 用enum代替int常量
 * 
 * 栗子参见:Planet与Operation
 * 策略枚举栗子:PayrollDay 场景:多个枚举常量同时共享相同的行为
 * 枚举中switch场景:给外部枚举类型增加特定常量行为,见Operation
 * @author Yangyang
 *
 */
public class Demo30 {
  public static void main(String[] args) {
    System.err.println("==========Planet类=========");
    double earthWeight = 1000.000;
    double mass = earthWeight/ EARTH.getSurfaceGravity();
    for(Planet p:Planet.values()){//星球名
      System.out.printf("%s 的质量为 %f%n",p,p.surfaceWeight(mass));
    }
    System.err.println("==========Operation类=========");
    double x = 5.20;
    double y = 13.14;
    for(Operation op:Operation.values()){//运算符
      System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
    }
  }
}
