package effectiveJava.t05;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 泛型
 * <?>  无限制通配符类型:只能包含某个未知对象类型的集合
 * <E extends Delayed>  E为Delayed的一个子类型
 * <T extends Comparable<T>> 针对可以与自身进行比较的每个类型T,max min...
 * <Collection<? super E>>  E的超类的集合
 * @author Yangyang
 *
 */
public class Demo23 {
  // <?>  无限制通配符类型:只能包含某个未知对象类型的集合
  static int numElementsInCommon(Set<?> s1,Set<?> s2){
    int result=0;
    for(Object o1:s1){
      if(s2.contains(o1))
        result++;
    }
    return result;
  }
  //<T extends Comparable<T>> 针对可以与自身进行比较的每个类型T
  static <T extends Comparable<T>> T max(List<T> list){
    Iterator<T> i = list.iterator();
    T result = i.next();
    while(i.hasNext()){
      T t = i.next();
      if(t.compareTo(result)>0)
        result = t;
    }
    return result;
  }
}
