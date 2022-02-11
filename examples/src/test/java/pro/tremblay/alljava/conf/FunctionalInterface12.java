/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.function.Consumer;

public class FunctionalInterface12 {

  @Test
  public void test() {
    Runnable r = () -> System.out.printf("Hello Henri");
    r.run();
  }

  public interface MyRunnable {
    void run();
  }

  @Test
  public void testEverything() {
    Consumer<String> consumer = s -> System.out.printf(s);
    consumer.accept("Hi");
  }

  public interface MyInterface {
    void accept(String val);
  }
}
