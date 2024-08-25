package com.coderpad.app.repository;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
  AtomicInteger id;

  IdGenerator() {
    this.id = new AtomicInteger(0);
  }

  public int getNewId() {
    return id.incrementAndGet();
  }
}