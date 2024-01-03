/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

class FunctionalInterface12 {

  // Talk about runnable
  // Add a method to MyInterface
  // Add static method
  // Add default method
  // Add private method
  // Consumer
  // Replace Consumer by MyInterface

  @Test
  void test() {
    Runnable r = () -> System.out.printf("Hello Henri");
    r.run();
  }

  @FunctionalInterface
  public interface MyRunnable {
    default void hello() {}
    static void world() {}
    private void underground() {}

    void run();
  }

  @Test
  void testEverything() {
    MyInterface consumer = s -> System.out.printf(s);
    consumer.accept("Hi");
  }

  public interface MyInterface {
    void accept(String val);
  }
}
