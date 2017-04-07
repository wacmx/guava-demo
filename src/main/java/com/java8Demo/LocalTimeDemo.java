package com.java8Demo;

import java.time.LocalTime;

/**
 * LocalTime类用于表示一天中的时间。 
 * LocalTime类的常用方法：
 *  1、 LocalTime.now()：获取系统当前时间。 
 *  2、 LocalTime.of(int hour,int minute,int second) 按指定时间创建LocalTime对象。 
 *  3、getHour()：返回小时。 
 *  4、getMinute()：返回分钟。 
 *  5、getSecond()：返回秒。
 * 
 * @author Administrator
 *
 */
public class LocalTimeDemo {
  public static void main(String[] args) {
    LocalTime time = LocalTime.now();
    System.out.println(time.getHour() + "时");
    System.out.println(time.getMinute() + "分");
    System.out.println(time.getSecond() + "秒");
    System.out.println(time.toString());
  }
}
