/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class VirtualThread34 {

  @Test
  public void test() {
    for (int i = 0; i < 100_000; i++) {
      System.out.println("Launch thread " + i);
      new Thread(() -> {
        try {
          TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }
  }

  // run with threads
  // startVirtualThread
  // pool, executor
}
