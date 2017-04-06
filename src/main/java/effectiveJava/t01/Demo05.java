package effectiveJava.t01;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建不必要的对象
 * 场景:
 * 1优先使用基本类型,而非装箱类型
 * 2.静态工厂方法优先于构造器,如Boolean.valueOf(String) 优先于 Boolean(String)
 * @author Yangyang
 *
 */
public class Demo05 {
	private  final Date birthDate=Calendar.getInstance().getTime();
	
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static {
		Calendar getCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		getCal.set(1946, Calendar.JANUARY,1,0,0,1);
		BOOM_START=getCal.getTime();
		getCal.set(1965, Calendar.JANUARY,1,0,0,1);
		BOOM_END=getCal.getTime();
	}
	
	public boolean isBabyBoom(){
		return birthDate.compareTo(BOOM_START)>=0&&birthDate.compareTo(BOOM_END)<0;
	}
}
