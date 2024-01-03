/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class VirtualThread34 {

  volatile boolean first = true;

  @Test
  public void test() throws Exception {
    for (int i = 0; i < 100_000; i++) {
      System.out.println("Launch thread " + i);
      Thread.startVirtualThread(() -> {
        try {
          TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
  }
}
