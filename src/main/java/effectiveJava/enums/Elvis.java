package effectiveJava.enums;

import java.util.Arrays;

public enum Elvis {
	// 定义一个枚举的元素，代表一个实例,通过他来调用,Elvis.INSTANCE.printSongs()
	INSTANCE;
	private String[] songs = { "a", "b" };

	public void printSongs() {
		System.out.println(Arrays.toString(songs));
	}
}
