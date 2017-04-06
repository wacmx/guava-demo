package com.lambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.model.Person;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Alin 
 * 使用Lambdas和Streams Stream是对集合的包装,通常和lambda一起使用。 使用lambdas可以支持许多操作,
 * 如 map, filter,limit, sorted, count, min, max, sum, collect 等等。
 * 同样,Stream使用懒运算,他们并不会真正地读取所有数据,遇到像getFirst() 这样的方法就会结束链式语法。
 */
public class Example3 {

  @SuppressWarnings("serial")
  public static void main(String[] args) {

    List<Person> javaProgrammers = new ArrayList<Person>() {
      {
        add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
        add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
        add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
        add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
        add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
        add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
        add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
        add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
        add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
        add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
      }
    };

    List<Person> phpProgrammers = new ArrayList<Person>() {
      {
        add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
        add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
        add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
        add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
        add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
        add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
        add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
        add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
        add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
      }
    };

    // forEach examples
    // Print programmers name
    System.err.println("所有程序员的姓名:");
    javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    // Increase salary by 5% to programmers
    System.err.println("\n\n给程序员加薪 5% :");
    Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());

    javaProgrammers.forEach(giveRaise);
    phpProgrammers.forEach(giveRaise);
    javaProgrammers.forEach((p) -> System.out.printf("%s earns now $%,d.%n", p.getFirstName(),
        p.getSalary()));
    phpProgrammers.forEach((p) -> System.out.printf("%s earns now $%,d.%n", p.getFirstName(),
        p.getSalary()));

    // filter examples
    // Print PHP programmers that earn more than $1,400
    System.err.println("\n下面是月薪超过 $1,400 的PHP程序员:");
    phpProgrammers.stream()
        .filter((p) -> (p.getSalary() > 1400))//过滤器
        .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    // 定义filters
    Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
    Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
    Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

    System.err.println("\n\n下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
    phpProgrammers.stream()
        .filter(ageFilter)
        .filter(salaryFilter)
        .filter(genderFilter)
        .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    // Reuse filters
    System.err.println("\n\n下面是年龄大于 24岁的女JAVA程序员:");
    javaProgrammers.stream()
        .filter(ageFilter)
        .filter(genderFilter)
        .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    // limit examples
    System.err.println("\n\n最前面的3个 Java程序员:");
    javaProgrammers.stream()
        .limit(3)//使用limit方法,可以限制结果集的个数
        .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    System.err.println("\n\n最前面的3个女性 Java程序员:");
    javaProgrammers.stream().filter(genderFilter).limit(3)
        .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    // sorted, collect, limit, min, max examples
    System.err.println("\n\n根据 name 排序,并显示前5个 Java程序员:");
    List<Person> sortedJavaProgrammers =javaProgrammers
            .stream()
            .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
            .limit(5).collect(toList());

    sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

    System.err.println("\n根据 salary排序Java程序员:");
    sortedJavaProgrammers =javaProgrammers
            .stream().sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
            .collect(toList());

    sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(),p.getLastName()));

    // min is faster than sorting and choosing the first
    System.err.println("\n工资最低的Java程序员:");
    Person pers = javaProgrammers
        .stream()
        .min((p1, p2) -> (p1.getSalary() - p2.getSalary())).get();

    System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(),pers.getSalary());

    System.err.println("\n工资最高的Java程序员:");
    Person person = javaProgrammers
        .stream()
        .max((p, p2) -> (p.getSalary() - p2.getSalary()))
        .get();

    System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(),person.getSalary());

    // map, collect examples
    System.err.println("\n将 PHP programmers 的 first name 拼接成字符串:");
    String phpDevelopers =phpProgrammers
        .stream()
        .map(Person::getFirstName)
        .collect(joining(" ; ")); // 在进一步的操作中可以作为标记(token) 

    System.out.println(phpDevelopers);

    System.err.println("\n将 Java programmers 的 first name 存放到 Set:");
    Set<String> javaDevFirstName =javaProgrammers
        .stream()
        .map(Person::getFirstName)
        .collect(toSet());

    javaDevFirstName.stream().forEach((s) -> System.out.printf("%s ", s));;

    System.err.println("\n将 Java programmers 的 first name 存放到 TreeSet:");
    TreeSet<String> javaDevLastName =javaProgrammers
        .stream()
        .map(Person::getLastName)
        .collect(toCollection(TreeSet::new));

    javaDevLastName.stream().forEach((s) -> System.out.printf("%s ", s));

    int numProcessorsOrCores = Runtime.getRuntime().availableProcessors();
    System.out.printf("\n\nParallel version on %s-core machine:", numProcessorsOrCores);

    // parrallel stream, sum examples
    System.err.println("\n计算付给 Java programmers 的所有money:");
    int totalSalary = javaProgrammers
        .parallelStream()
        .mapToInt(p -> p.getSalary())
        .sum();

    System.out.printf("付给 Java programmers 的所有money: $%,d %n", totalSalary);

    // Get count, min, max, sum, and average for numbers
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    IntSummaryStatistics stats = numbers
        .stream()
        .mapToInt((x) -> x)
        .summaryStatistics();

    System.out.println("List中最大的数字 : " + stats.getMax());  
    System.out.println("List中最小的数字 : " + stats.getMin());  
    System.out.println("所有数字的总和   : " + stats.getSum());  
    System.out.println("所有数字的平均值 : " + stats.getAverage());  
  }

}
