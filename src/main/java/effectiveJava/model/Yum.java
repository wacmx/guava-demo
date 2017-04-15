package effectiveJava.model;

public class Yum {
  //拷贝构造器(构造器,唯一参数是该构造器的类)
  public Yum(Yum yum){}
  //拷贝工厂(类似拷贝构造器的静态工厂)
  public static Yum getInstance(Yum yum){
    return yum;
   }
}
