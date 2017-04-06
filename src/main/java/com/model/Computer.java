package com.model;

import java.util.Optional;

public class Computer {
  private Optional<Soundcard> soundcard;

  public Optional<Soundcard> getSoundcard() {
    return soundcard;
  }

  public void setSoundcard(Optional<Soundcard> soundcard) {
    this.soundcard = soundcard;
  }

  @Override
  public String toString() {
    return "Computer [soundcard=" + soundcard + "]";
  }
  
}
