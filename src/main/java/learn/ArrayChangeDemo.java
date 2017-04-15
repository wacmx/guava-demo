package learn;

import java.util.ArrayList;
/**
 * 数组扩容(利用ArrayList):数组长度不可变
 * @author Yangyang
 *
 */
public class ArrayChangeDemo {
  public static void main(String[] args) {
    String[] arr={"a1","a2","a3"};
    ArrayList<String> list=new ArrayList<>();
    for(int i=0;i<arr.length;i++){//将原数组放入集合
      list.add(arr[i]);
    }
    for(int i=4;i<15;i++){//增加11个元素
      list.add("a"+i);
    }
    list.remove(13);//移除第13个元素
    System.out.println(list+"\n当前数组长度为:"+list.size());
  }
}
