package effectiveJava.t02;

/**
 * 私有构造器或枚举类型强化Singleton属性
 */
public class Demo03 {
	// 1. 饿汉式,线程安全,可以通过反射机制攻击
	/*
	 * private static Demo03 INSTANCE=new Demo03(); private Demo03(){
	 * 
	 * } public static Demo03 getInstance(){ return INSTANCE; }
	 */

	// 2.懒汉式
	private static Demo03 INSTANCE = null;

	private Demo03() {

	}

	public static Demo03 getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Demo03();
		return INSTANCE;
	}

	// 将域声明为瞬时,防止反序列化攻击,
	private Object readResolve() {
		return INSTANCE;
	}
	// 3.单元素枚举,详见Elvis.java(最佳方法)
	
	public static void main(String[] args) {
		//测试
		Demo03 a1=Demo03.getInstance();
		Demo03 a2=Demo03.getInstance();
		System.out.println(a1+"\n"+a2);
	}
}
