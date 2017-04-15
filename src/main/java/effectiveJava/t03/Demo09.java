package effectiveJava.t03;

import java.util.HashMap;
import java.util.Map;

import effectiveJava.model.PhoneNumber;
/**
 * 覆盖equals时总要覆盖hashCode
 * @author Yangyang
 *
 */
public class Demo09 {
  public static void main(String[] args) {
    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(new PhoneNumber(707, 867, 5309), "Gakki");
    System.out.println(m.get(new PhoneNumber(707, 867, 5309)));// 未覆盖hashcode前为null,覆盖后为Gakki
  }
}
