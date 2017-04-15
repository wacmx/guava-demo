package effectiveJava.t04;

import java.util.Collection;
import java.util.Set;

/**
 * 复合优先于继承
 * 分为两部分:复合(引用现有类的一个实例)与转发(新类每个实例方法都可调用被包含的现有实例中对应的方法)
 * 优点:稳固,不依赖现有类的任何细节,子类添加新方法也不会影响现有的类
 * 当前为转发:新类每个实例方法都可调用被包含的现有实例中对应的方法
 * @author Yangyang
 *
 */
public class Demo16_2<E> extends Demo16_1<E> {
  private int addCount = 0;
  
  public Demo16_2(Set<E> s) {
    super(s);
  }
  
  @Override
  public boolean add(E e){
    addCount++;
    return super.add(e);
  }
  
  @Override
  public boolean addAll(Collection<? extends E> c){
    addCount++;
    return super.addAll(c);
  }
  
  public int getCount(){
    return addCount;
  }
  
}
