package effectiveJava.t04;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 复合优先于继承
 * 分为两部分:复合(引用现有类的一个实例)与转发(新类每个实例方法都可调用被包含的现有实例中对应的方法)
 * 优点:稳固,不依赖现有类的任何细节,子类添加新方法也不会影响现有的类
 * 当前为复合:引用现有类的一个实例
 * @author Yangyang
 *
 */
public class Demo16_1<E> implements Set<E> {
  private final Set<E> s;

  public Demo16_1(Set<E> s) {
    super();
    this.s = s;
  }

  public int size() {
    return s.size();
  }

  public boolean isEmpty() {
    return s.isEmpty();
  }

  public boolean contains(Object o) {
    return s.contains(o);
  }

  public Iterator<E> iterator() {
    return s.iterator();
  }

  public Object[] toArray() {
    return s.toArray();
  }

  public <T> T[] toArray(T[] a) {
    return s.toArray(a);
  }

  public boolean add(E e) {
    return s.add(e);
  }

  public boolean remove(Object o) {
    return s.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return s.containsAll(c);
  }

  public boolean addAll(Collection<? extends E> c) {
    return s.addAll(c);
  }

  public boolean retainAll(Collection<?> c) {
    return s.retainAll(c);
  }

  public boolean removeAll(Collection<?> c) {
    return s.removeAll(c);
  }

  public void clear() {
    s.clear();
  }

  
}
