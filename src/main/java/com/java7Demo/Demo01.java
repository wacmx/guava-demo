package com.java7Demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
  // 改进的通用实例创建类型推断
  Map<String, List<String>> map = new HashMap<>();
  // 数字字面量下划线支持,可以使用下划线分隔长int以及long了
  int one_million = 100_0000;
  
  public static void main(String[] args) {
    // switch中使用string
    String s = "hello";
    switch (s) {
      case "ssw":
        System.out.println("ssw");
        break;
      case "foo":
        System.out.println("foo");
        break;
      default:
        System.out.println("haha");
        break;
    }
  }
} 
