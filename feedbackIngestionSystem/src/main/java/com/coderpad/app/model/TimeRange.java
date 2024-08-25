package com.coderpad.app.model;

public class TimeRange {
  long startMillis;
  long endMillis;

  public TimeRange(long startMillis , long endMillis) {
    this.startMillis = startMillis;
    this.endMillis = endMillis;    
  }

  public long getStartMillis() {
      return startMillis;
  }

  public long getEndMillis() {
      return endMillis;
  }
}