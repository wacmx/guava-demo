package com.java8Demo;

import java.util.Optional;

import com.model.Computer;
import com.model.Soundcard;
import com.model.USB;
/**
 * 来源网站:
 * http://www.hollischuang.com/archives/885
 */
public class OptionalDemo2 {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    // 空的Optional
    Optional<Computer> computer = Optional.empty();
    // 包含非空值的Optional(一旦soundcard是null，这段代码会立即抛出一个NullPointException)
    Soundcard soundcard=new Soundcard();
    Optional<Soundcard> sc=Optional.of(soundcard);
    // 可能为空的Optional(如果soundcard是null那么这个Optional将会是empty)
    Optional<Soundcard> sc1=Optional.ofNullable(soundcard);
    
    System.err.println("=========值存在的时候进行进一步的操作=========");
    
    //1.0原先需要非空判断
    if(soundcard !=null)
      System.out.println(soundcard);
    //1.1现在，可以使用ifPresent()方法
    sc1.ifPresent(System.out::println);
    
    System.err.println("=========默认值和默认操作=========");
    
    //2.0某个操作返回空的时候给出一个默认值通常的做法是使用三目运算符
    Soundcard maybeSoundCard=new Soundcard();
    Soundcard soundcard1 = maybeSoundCard != null ? maybeSoundCard : new Soundcard();
    //2.1使用Optional对象的ifElse方法改进这个代码
    Optional<Soundcard> maybeSoundCard1=Optional.ofNullable(maybeSoundCard);
    Soundcard soundcard2=maybeSoundCard1.orElse(new Soundcard());
    //2.2想在空值的时候抛出一个异常，可以使用ifElseThrow方法
    Soundcard soundcard3=sc1.orElseThrow(IllegalStateException::new);
    
    System.err.println("=========使用filter过滤特定值=========");
    //3.0如果需要避免空指针异常，通常的方式是检测非空然后调用getVersion方法
    USB usb=new USB();
    if(usb!=null && "3.0".equals(usb.getVersion()))
      System.out.println("ok");
    //3.1使用Optional的filter,filter方法带有一个Predicate的参数，如果Optional容器里面的对象存在并且满足这个predicate,那么filter返回那个对象，否则就返回empty的Optional
    Optional<USB> maybeUSB = Optional.ofNullable(usb);
    /*maybeUSB.filter(usb -> "3.0".equals(usb.getVersion())
        .ifPresent(()-> System.out.println("ok"));*/
    
    System.err.println("=========使用map/flatMap转换值=========");
    //4.1需要从某个对象里面提取出特定的值。
    /*if(soundcard != null){
      USB usb1 = soundcard.getUSB();
      if(usb1 != null && "3.0".equals(usb1.getVersion()){
        System.out.println("ok");
      }
    }*/
    //4.2 使用Optional的map方法
    Optional<USB> usb2=maybeSoundCard1.flatMap(Soundcard::getUSB);
    //4.3结合使用map和filter可以检测某个声卡是否有USB 3.0的接口
    /*maybeSoundCard1.flatMap(Soundcard::getUSB)
      .filter(usb -> "3.0".equals(usb.getVersion())
      .ifPresent(() -> System.out.println("ok"));*/
    
    
    // 使用Optional类来实现传统的空指针检测：
    String name=computer.flatMap(Computer::getSoundcard)
        .flatMap(Soundcard::getUSB)
        .map(USB::getVersion)
        .orElse("UNKNOWN");
  }
}
