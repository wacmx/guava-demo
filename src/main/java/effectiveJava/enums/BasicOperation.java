package effectiveJava.enums;

import effectiveJava.t06.Demo34;

public enum BasicOperation implements Demo34{
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
  private final String symbol;
  private BasicOperation(String symbol) {
    this.symbol = symbol;
  }
  @Override
  public String toString() {
    return symbol;
  }
}