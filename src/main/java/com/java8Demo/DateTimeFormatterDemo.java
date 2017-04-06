package com.java8Demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter类用于将字符串解析为日期
 * @author Yangyang
 *
 */
public class DateTimeFormatterDemo {
  public static void main(String[] args) {
    /**
     * staticofPattern(String pattern);
     * 作用：按pattern字符串指定的格式创建DateTimeFormatter对象。
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
    /**
     * LocalDateTime.parse(strDate, formatter);
     * 作用：按指定模板和字符串创建LocalDateTime对象。
     */
    LocalDateTime date = LocalDateTime.parse("2017-05-20:13:14:20", formatter);
    
    System.out.println(date.toString());
  }
}
