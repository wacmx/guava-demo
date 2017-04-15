package effectiveJava.t06;

import java.util.Arrays;
import java.util.Collection;

import effectiveJava.enums.ExtendedOperation;

public class Demo34Test {
  public static void main(String[] args) {
    double x=5.20;
    double y=13.14;
    test1(ExtendedOperation.class,x,y);//方法1:<T extends Enum<T> & Operation>
    test2(Arrays.asList(ExtendedOperation.values()),x,y);//方法2:Collection<? extends Operation>
  }
  //有限制的类型令牌,<T extends Enum<T> & Operation>:T对象既表示枚举,又表示Demo34的子类型
  private static <T extends Enum<T> & Demo34> void test1(Class<T> opSet, double x, double y) {
    for(Demo34 op:opSet.getEnumConstants()){
      System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
    }
  }
  //有限制的通配符类型,Collection<? extends Operation>
  private static void test2(Collection<? extends Demo34> opSet, double x, double y) {
    for(Demo34 op:opSet){
      System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x, y));
    }
  }
}
