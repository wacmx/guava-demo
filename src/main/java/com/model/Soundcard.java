package com.model;

import java.util.Optional;

public class Soundcard {
  private Optional<USB> usb;

  public Optional<USB> getUSB() {
    return usb;
  }

  public void setUSB(Optional<USB> usb) {
    this.usb = usb;
  }

  @Override
  public String toString() {
    return "Soundcard [usb=" + usb + "]";
  }
  
}
