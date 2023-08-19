/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class FunctionalInterface12 {

  @Test
  void test() {
    Runnable r = () -> System.out.printf("Hello Henri");
    r.run();
  }

  public interface MyRunnable {
    void run();
  }

  @Test
  void testEverything() {
    Consumer<String> consumer = s -> System.out.printf(s);
    consumer.accept("Hi");
  }

  public interface MyInterface {
    void accept(String val);
  }
}
