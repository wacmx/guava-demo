package effectiveJava.t03;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import effectiveJava.model.PhoneNumber;

/**
 * 考虑实现Comparable接口
 * 
 * compareTo等同性比较,顺序比较,支持泛型
 * 实现该接口,实例具有内在的排序关系
 * @author Yangyang
 *
 */
public class Demo12 {
  private int areaCode;
  private int prefix;
  private int lineNumber;
  
  public static void main(String[] args) {
    Set<String> s = new TreeSet<String>();
    Collections.addAll(s, args);
    System.out.println(s);
  }
  public int CompareTo(PhoneNumber pn){
    int areaCodeDiff =areaCode-pn.getAreaCode();
    if(areaCodeDiff!=0)
      return areaCodeDiff;
    int prefixDiff =prefix-pn.getPrefix();
    if(prefixDiff!=0)
      return prefixDiff;
    int lineNumberDiff =lineNumber-pn.getLineNumber();
    return lineNumberDiff;
    /**
     * 比较整数,可以用<,>比较,而浮点类型,用Double.compare或Float.compare
     */
   /* if(areaCode<pn.getAreaCode())
      return -1;
    if(areaCode>pn.getAreaCode())
      return 1;
    if(prefix<pn.getPrefix())
      return -1;
    if(prefix>pn.getPrefix())
      return 1;
    if(lineNumber<pn.getLineNumber())
      return -1;
    if(lineNumber>pn.getLineNumber())
      return 1;
    return 0;*/
  }
}
