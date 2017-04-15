package effectiveJava.enums;

import effectiveJava.t06.Demo34;

public enum ExtendedOperation implements Demo34{
  EXP("^"){
    public double apply(double x,double y){
      return Math.pow(x, y);
    }
  },
  REMAINDER("%"){
    public double apply(double x,double y){
      return x%y;
    }
  };
  
  private final String symbol;
  private ExtendedOperation(String symbol) {
    this.symbol = symbol;
  }
  @Override
  public String toString() {
    return symbol;
  }
}
