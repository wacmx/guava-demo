package effectiveJava.t03;
/**
 * 谨慎覆盖clone()
 * 场景:拷贝数组
 * 
 * 实现拷贝最好的方法是提供一个拷贝构造器(构造器,唯一参数是该构造器的类)/拷贝工厂
 * 详见Yum
 * @author Yangyang
 *
 */
public class Demo11 implements Cloneable{
  private Entry[] buckets ;
  private static class Entry{
    Object key;
    Object value;
    Entry next;
    public Entry(Object key, Object value, Entry next) {
      super();
      this.key = key;
      this.value = value;
      this.next = next;
    }
    //对每一个非空散列桶进行深度拷贝
    Entry deepCopy(){
       Entry result = new Entry(key, value, next);
       for(Entry p =result;p.next != null;p=p.next){
         p.next = new Entry(p.next.key, p.next.value, p.next.next);
       }
       return result;
    }
  }
  @Override
  public Demo11 clone(){
    try {
      //调用super.clone()方法
      Demo11 result = (Demo11) Demo11.super.clone();
      //初始化成新的散列桶数组
      result.buckets = new Entry[buckets.length];
      //迭代 & 调用克隆对象内部状态的clone方法
      for(int i=0;i<buckets.length;i++){
        if(buckets[i] != null)
          result.buckets[i] = buckets[i].deepCopy();
      }
      return result;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
