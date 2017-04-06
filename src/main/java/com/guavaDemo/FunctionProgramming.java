package com.guavaDemo;


import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 
 * @ClassName: FunctionProgramming
 * @Description: guava之函数编程
 * @author minjun
 * @date 2015年6月14日 下午7:06:43
 * 
 */
@SuppressWarnings("unused")
public class FunctionProgramming {

	/**
	 * 
	 * @Title: testFunction
	 * @Description: Fucntion<K,V>接口提供的apply是用来将对象K转换为对象V的
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void testFunction() {
		// 将map存储进Function实现类中
		Function<String, Classroom> lookup = getFunctionForDefaultMap();

		Function<Classroom, String> append = new Function<Classroom, String>() {

			@Override
			public String apply(Classroom input) {
				return Joiner.on(",").join(input.students);
			}

		};

		// 先调用lookup.apply("三年级二班")查询班级，然后将该对象继续apply('三年二班的对象')，用逗号连接该班级中的学生名字
		Function<String, String> compose = Functions.compose(append, lookup);

		Assert.assertEquals("tom,jack", compose.apply("三年级二班"));
	}

	private Function<String, Classroom> getFunctionForDefaultMap() {
		Map<String, Classroom> map = Maps.newHashMap();
		map.put("三年级二班",
				new Classroom(1, "三年级二班", Sets.newHashSet("jack", "tom")));
		map.put("四年三班",
				new Classroom(2, "四年三班", Sets.newHashSet("owen", "jerry")));

		return Functions.forMap(map);
	}

	private class Classroom {
		private int id;

		private String name;

		private Set<String> students;

		public Classroom() {
		}

		public Classroom(int id, String name, Set<String> students) {
			super();
			this.id = id;
			this.name = name;
			this.students = students;
		}

	}

	/**
	 * 
	 * @Title: testPredicate
	 * @Description: 不同于Function的apply改变对象，Predicate<T>是用来过滤对象T的
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void testPredicate() {
		Classroom c1 = new Classroom(1, "三年级二班", Sets.newHashSet("jack", "tom",
				"kelly"));
		Classroom c2 = new Classroom(2, "四年三班",
				Sets.newHashSet("owen", "jerry"));
		Classroom c3 = new Classroom(3, "六年二班", Sets.newHashSet("jobs"));
		// 学生数量大于1
		Predicate<Classroom> number = new Predicate<Classroom>() {

			@Override
			public boolean apply(Classroom input) {
				return input.students.size() > 1;
			}
		};
		// 学生id小于3
		Predicate<Classroom> id = new Predicate<Classroom>() {

			@Override
			public boolean apply(Classroom input) {
				return input.id < 3;
			}
		};

		// 当过滤条件能够让number和id同时成立的时候(学生数量大于1并且学生id小于3的班级是不是c1)，返回true
		Assert.assertTrue(Predicates.and(number, id).apply(c1));

		// 用新的数据填充map,并注入lookup函数
		Function<String, Classroom> lookup = getFunctionForDefaultMap();

		// 判断三年级二班的学生数量是否大于1
		Assert.assertTrue(Predicates.compose(number, lookup).apply("三年级二班"));
	}

	@Test
	public void testSupplier() {
		// 使用memorize包装之后的Supplier，以后再从这个里面get()对象的时候，都能保证是同一个对象
		Supplier<Classroom> wrapped = Suppliers
				.memoize(new ClassroomSupplier());

		// 指定保持这个单例对象的时间，一旦过期，就会重新生成新的对象
		// Supplier<Classroom> w = Suppliers
		// .memoizeWithExpiration((new ClassroomSupplier()), 10L,
		// TimeUnit.MINUTES);

		Classroom c1 = wrapped.get();

		Classroom c2 = wrapped.get();

		Assert.assertEquals(c1, c2);
	}

	private class ClassroomSupplier implements Supplier<Classroom> {

		@Override
		public Classroom get() {
			return new Classroom();
		}
	}

}