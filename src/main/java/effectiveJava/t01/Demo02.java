package effectiveJava.t01;

/**
 * 多个构造器参数,使用构建器/JavaBean模式 set get/Builder模式
 *  Builder模式具名,可选参数
 */
public class Demo02 {
	private final int servingSize;
	private final int servings;
	private final int fat;
	private final int sodium;

	public static class Builder {
		// 必要的元素
		private final int servingSize;
		private final int servings;
		// 可选的元素
		private int fat = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Demo02 build() {
			return new Demo02(this);
		}
	}

	public Demo02(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
	}

  @Override
  public String toString() {
    return "Demo02 [servingSize=" + servingSize + ", servings=" + servings + ", fat=" + fat
        + ", sodium=" + sodium + "]";
  }
	
	
}
