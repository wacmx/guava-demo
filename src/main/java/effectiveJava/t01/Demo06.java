package effectiveJava.t01;
/**
 * 消除过期的对象引用
 *	场景:
 *1.自己管理内存的类,如Stack类
 *2.缓存:生命周期由外部引用决定,可以用WeakHashMap代表缓存
 *清除缓存可以由Timer/ScheduledThreadPoolExecutor完成.
 *简单缓存:LinkedHashMap.removeEldestEntry
 *复杂缓存:java.lang.ref
 *3.监听器/其他回调:只保存它们的弱引用(保存为WeakHashMap的key)
 *
 *Heap剖析工具
 */
public class Demo06 {

}
