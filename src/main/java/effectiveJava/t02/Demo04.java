package effectiveJava.t02;

/**
 * 私有构造器强化不可实例化能力
 * 场景:Math,Arrays,Collections等util
 * @author Yangyang
 *
 */
public class Demo04 {
	//构造器私有,外部不可访问
	private Demo04() {
		throw new AssertionError();//避免在类内部调用
	}

}
