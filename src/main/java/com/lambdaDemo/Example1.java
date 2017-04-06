package com.lambdaDemo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alin 
 * 基本的Lambda例子
 * Lambda表达式的语法 基本语法: 
 * (parameters) -> expression 或 (parameters) ->{ statements; }
 */
public class Example1 {

  public static void main(String[] args) {

    String[] atp =
        {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer","Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet","John Isner"};
    List<String> players = Arrays.asList(atp);

    // 以前的循环方式
    for (String player : players) {
      System.out.print(player + "; ");
    }

    System.out.println("");

    // 使用 lambda 表达式以及函数操作(functional operation)
    players.forEach((player) -> System.out.print(player + "; "));

    System.out.println("");

    // 在 Java 8 中使用双冒号操作符(double colon operator)
    players.forEach(System.out::println);

    System.out.println("");

    // 1.1使用匿名内部类
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello world !");
      }
    }).start();

    // 1.2使用 lambda expression
    new Thread(() -> System.out.println("Hello world !")).start();

    // 2.1使用匿名内部类
    Runnable race1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello world !");
      }
    };

    // 2.2使用 lambda expression
    Runnable race2 = () -> System.out.println("Hello world !");

    // 直接调用 run 方法(没开新线程哦!)
    race1.run();
    race2.run();
  }

}
