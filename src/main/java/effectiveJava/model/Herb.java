package effectiveJava.model;

/**
 * 香草类
 * @author Yangyang
 *
 */
public class Herb {
public enum Type{ANNUAL,PERENNIAL,BIENNIAL}
  
  private final String name;
  private final Type type;
  public Herb(String name, Type type) {
    this.name = name;
    this.type = type;
  }
  
  @Override
  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }
  
}
