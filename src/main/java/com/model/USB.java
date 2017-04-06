package com.model;

public class USB {
  private String version;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "USB [version=" + version + "]";
  }
  
}
