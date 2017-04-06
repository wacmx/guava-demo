package com.exception;

public class ValueAbsentException extends Throwable {
  
  private static final long serialVersionUID = -7894158518179777150L;

  public ValueAbsentException() {
    super();
  }
 
  public ValueAbsentException(String msg) {
    super(msg);
  }
 
  @Override
  public String getMessage() {
    return "No value present in the Optional instance";
  }
}
