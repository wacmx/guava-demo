package com.java8Demo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ZonedDateTime处理日期和时间与相应的时区。
 * 
 * 常用方法：
 *  1、ZonedDateTime.now() 获取系统当前日期和事件。
 *  2、String format(DateTimeFormatter formatter)。
 * 按指定模板将日期对象格式化为一个字符串。
 * 
 * @author Administrator
 *
 */
public class ZonedDateTimeDemo {
  public static void main(String[] args) {
    ZonedDateTime date=ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String strDate = date.format(formatter);
    System.out.println(strDate.toString());
  }
}
