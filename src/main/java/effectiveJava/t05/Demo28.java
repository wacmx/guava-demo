package effectiveJava.t05;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 利用有限制通配符提升API灵活性
 * producer-extends     consumer-super
 * 
 * Comparable Comparator始终是消费者, Comparable<? extends T>
 * 
 *  * <?>  无限制通配符类型:只能包含某个未知对象类型的集合
 * <E extends Delayed>  E为Delayed的一个子类型
 * <T extends Comparable<? extends T>> 针对可以与自身进行比较的每个类型T,max min...
 * <Collection<? super E>>  E的超类的集合
 * @author Yangyang
 *
 */
public class Demo28<E> {
  public Demo28() {}
  public void push(E e){}
  public E pop(){
    return null;
  }
  public boolean isEmpty(){
    return false;
  }

  public void pushAll(Iterable<? extends E> src){
    for(E e : src){
      push(e);
    }
  }
  public void popAll(Collection<? super E> dst){
    while(!isEmpty()){
      dst.add(pop());
    }
  }
  
  public static <T extends Comparable<? super T>> T max(List<? extends T> list){
    //iterator与list泛型一致
    Iterator<? extends T> i = list.iterator();
    T result = i.next();
    while(i.hasNext()){
      T t = i.next();
      if(t.compareTo(result)>0)
        result = t;
    }
    return result;
  }
}
