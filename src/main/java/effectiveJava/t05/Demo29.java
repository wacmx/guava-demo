package effectiveJava.t05;

import effectiveJava.model.Favourites;

/**
 * 优先考虑类型安全的异构容器
 * 
 * 将key参数化,而非容器参数化,通过key来插入或获取value
 * @author Yangyang
 *
 */
public class Demo29 {
  //单元素容器
  /*ThreadLocal<String> tl=  new ThreadLocal<>();
  AtomicReference<String> ar= new AtomicReference<>();*/
  public static void main(String[] args) {
    Favourites f = new Favourites();
    f.putFavourite(String.class, "Ruby");
    f.putFavourite(Integer.class, 123);
    f.putFavourite(Class.class,Favourites.class);
    String favouriteString= f.getFavourite(String.class);
    Integer favouriteInteger= f.getFavourite(Integer.class);
    Class<?> favouriteClass= f.getFavourite(Class.class);
    System.out.printf("%s %x %s%n",favouriteString,favouriteInteger,favouriteClass);
  }
  
}
