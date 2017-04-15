package effectiveJava.t04;

 import static effectiveJava.util.PhysicalConstants.*;

/**
 * 接口只定义类型,不定义常量
 * 
 * 常量可以用枚举||不可实例化的工具类public static final double AVG_XXX=232.00;
 * 大量利用工具类导出常量可用静态导入  import static com.xxx.xxx.*
 * @author Yangyang
 *
 */
public class Demo19 {
  double atom(double mols){
   return AVO*mols;
  }
}
