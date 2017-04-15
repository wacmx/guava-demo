package effectiveJava.t02;

public class Demo02Test {
	public static void main(String[] args) {
		Demo02 demo = new Demo02.Builder(240, 8).fat(100).sodium(520).build();
		System.out.println(demo);
	}
}
