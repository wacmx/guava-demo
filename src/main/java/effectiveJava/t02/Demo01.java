package effectiveJava.t02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 静态工厂方法替代构造器 优势:1.有名称2.不必每次调用都创建新的对象3.可返回任何原返回类型的子类型4.代码简洁
 * 场景:一个类需要多个带有相同签名的构造器时,通过名称突出区别
 */
public class Demo01 {

	public Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}

	Map<String, List<String>> map = new HashMap<>();// 使用静态工厂前的调用方式

	public static <K, V> HashMap<K, V> newInstance() {
		return new HashMap<>();
	}

	Map<String, List<String>> map1 = Demo01.newInstance();// 使用静态工厂后的调用方式

}
