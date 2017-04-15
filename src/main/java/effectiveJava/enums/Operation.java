package effectiveJava.enums;
/**
 * 四则运算demo
 * @author Yangyang
 *
 */
public enum Operation {
  PLUS("+"){
    public double apply(double x,double y){return x+y;}
  },
  MINUS("-"){
    public double apply(double x,double y){return x-y;}
  },
  TIMES("*"){
    public double apply(double x,double y){return x*y;}
  },
  DIVIDE("/"){
    public double apply(double x,double y){return x/y;}
  };
  //运算符
  private final String symbol;
  
  private Operation(String symbol) {this.symbol = symbol;}
  //将ADD转化为+...
  @Override
  public String toString(){return symbol;}

  public abstract double apply(double x,double y); 
  
  
  //switch用法
  public static Operation inverse(Operation op){
    switch (op) {
      case PLUS: return Operation.PLUS;
      case MINUS:return Operation.MINUS;
      case DIVIDE:return Operation.DIVIDE;
      case TIMES:return Operation.TIMES;
      default:throw new AssertionError("Unknown op"+op);
    }
  }
}
