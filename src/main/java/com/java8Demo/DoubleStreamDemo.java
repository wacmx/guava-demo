package com.java8Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.model.Person;

/**
 * 一、DoubleStream接口表示元素类型是double的数据源。
 * 二、DoubleStream接口的常用方法： 
 *  1、max().getAsDouble()：获取流中数据集的最大值。
 *  2、stream.min().getAsDouble() ：获取流中数据集的最小值。
 *  3、stream.average() ：获取流中数据集的平均值。 
 * 三、获取DoubleStream
 * 集合变量.mapToDouble()
 * 
 * @author Administrator
 *
 */
public class DoubleStreamDemo {
  public static void main(String[] args) {
    List<Person> people = createPeople();//集合初始化
    double avgSalary = people.stream()
        .filter( p ->p.getFirstName().indexOf("菲")>=0)//过滤器
        .mapToDouble(p->p.getSalary())
        .average()
        .getAsDouble();
    System.out.println("包含菲字的所有人的薪水"+avgSalary);
    
    Stream<Person> stream=people.stream();
    stream.forEach(p -> System.out.println(p.toString()));//输出集合
  }
  private static List<Person> createPeople() {
    List<Person> people = new ArrayList<>();
    Person p=new Person("刘亦菲", "a", null, null, 30, 15000);
    people.add(p);
    p=new Person("王菲",  "b", null, null, 30, 14000);
    people.add(p);
    p=new Person("新垣结衣",  "c", null, null, 30, 15000);
    return people;
  }
}
