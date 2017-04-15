package effectiveJava.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 异构容器的实现demo
 * 类型安全:返回类型与请求类型一致
 * 异构:key可以为不同类型
 * @author Yangyang
 *
 */
public class Favourites {
  private Map<Class<?>,Object> favourites = new HashMap<>();
  
  public Favourites() {
  }
  
  public <T> void putFavourite(Class<T> type,T instance){
    if(type == null)
      throw new NullPointerException();
    //favourites.put(type, instance);
    //检验instance是否是type表示类型的实例,避免恶意的客户端破坏实例的类型安全
    favourites.put(type, type.cast(instance));
  }
  
  public <T> T  getFavourite(Class<T> type){
    //动态转换返回对象的引用(object)为T类型
    return type.cast(favourites.get(type));
  }
}
