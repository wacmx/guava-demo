package effectiveJava.enums;

import java.lang.reflect.Constructor;

public class ElvisTest {
	public static void main(String[] args) {
		Constructor<?>[] array=Elvis.class.getDeclaredConstructors();
		for(Constructor<?> c:array){
			c.setAccessible(true);
			// c.newInstance();//异常
		}
	}
}
