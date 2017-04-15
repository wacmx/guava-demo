package effectiveJava.enums;
/**
 * 用实例域替代序数
 * 永远不要根据枚举序数导出与她相关的值,而是将她保存在一个实例中
 * @author Yangyang
 *
 */
public enum Ensemble {
  SOLO(1),DUET(2),TRIO(3),QUARTET(4),QUINTET(5);
  
  private final int number;

  private Ensemble(int size) {
    this.number = size;
  }
  
  public int number(){
    return number;
  }
}
