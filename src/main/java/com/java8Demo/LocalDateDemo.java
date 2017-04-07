package com.java8Demo;

import java.time.LocalDate;

/**
 * LocalDate类使用ISO日历表示年、月、日。
 * LocalDate类的常用方法： 
 * 1、 LocalDate.now()：获取系统当前日期。 
 * 2、 LocalDate.of(int year,int month,int dayOfMonth) 按指定日期创建LocalDate对象。
 * 3、getYear()：返回日期中的年份。 
 * 4、getMonth()：返回日期中的月份。
 * 5、getDayOfMonth()：返回月份中的日。
 * 
 * @author Administrator
 *
 */
public class LocalDateDemo {
  public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    System.out.println(date.getYear() + "年");
    System.out.println(date.getMonthValue() + "月");
    System.out.println("本年第" + date.getDayOfYear() + "天");
    System.out.println("本月第" + date.getDayOfMonth() + "天");
    System.out.println("星期:" + date.getDayOfWeek());
    System.out.println("日期:" + date.toString());
  }
}
