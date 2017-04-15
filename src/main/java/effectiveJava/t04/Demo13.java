package effectiveJava.t04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使类和成员的访问性最小化
 * @author Yangyang
 *
 */
public class Demo13 {
  //私有的数组
  private static final String[] PRIVATE_VALUES={"a1","a2","a3"};
  /**
   * 私有属性的访问方法(两种方法)
   */
  //1.,增加一个公有的不可变列表
  public static final List<String> VALUES =Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
  //2.添加一个公有方法,返回私有数组的一个备份
  public static final String[] values(){
    return PRIVATE_VALUES.clone();
  }
}
