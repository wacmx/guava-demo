package effectiveJava.t02;

import effectiveJava.util.CaseInsensitiveString;

/**
 * equals
 */
public class Demo01 {
  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";
    System.out.println(cis.equals(s) + "\n" + s.equals(cis)+"\n");
  }
}
