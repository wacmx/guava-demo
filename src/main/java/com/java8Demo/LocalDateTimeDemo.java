package com.java8Demo;

import java.time.LocalDateTime;

/**
 * LocalDateTime类用于表示日期和时间
 * 
 * @author Administrator
 */
public class LocalDateTimeDemo {
  public static void main(String[] args) {
    // 获取系统当前时间
    LocalDateTime date = LocalDateTime.now();
    System.out.println(date.getYear() + "年");
    System.out.println(date.getMonthValue() + "月");
    System.out.println(date.getDayOfMonth() + "日");
    System.out.println(date.getHour() + "时");
    System.out.println(date.getMinute() + "分");
    System.out.println(date.getSecond() + "秒");
    System.out.println(date.toString());
  }
}
