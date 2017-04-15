package effectiveJava.model;

public class PhoneNumber {
  private final short areaCode;
  private final short prefix;
  private final short lineNumber;
  
  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    rangeCheck(areaCode,999,"area code");
    rangeCheck(prefix,999,"prefix");
    rangeCheck(lineNumber,9999,"lineNumber");
    this.areaCode = (short) areaCode;
    this.prefix = (short) prefix;
    this.lineNumber = (short) lineNumber;
  }
  
  private static void rangeCheck(int arg, int max, String name) {
    if(arg<0 ||arg>max)
      throw new IllegalArgumentException(name+":"+arg);
  }
  
  @Override
  public String toString() {
    return "PhoneNumber [areaCode=" + areaCode + ", prefix=" + prefix + ", lineNumber=" + lineNumber
        + "]";
  }
  
  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + areaCode;
    result = prime * result + lineNumber;
    result = prime * result + prefix;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PhoneNumber other = (PhoneNumber) obj;
    if (areaCode != other.areaCode)
      return false;
    if (lineNumber != other.lineNumber)
      return false;
    if (prefix != other.prefix)
      return false;
    return true;
  }

  public short getAreaCode() {
    return areaCode;
  }

  public short getPrefix() {
    return prefix;
  }

  public short getLineNumber() {
    return lineNumber;
  }
}
