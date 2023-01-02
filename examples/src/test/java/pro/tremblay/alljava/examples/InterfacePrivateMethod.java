/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import java.util.Arrays;

public class InterfacePrivateMethod {

public interface Printer {
  private void print(String s) {
    System.out.println(s);
  }

  default void printAll(String[] list) {
    Arrays.stream(list).forEach(this::print);
  }
}
}
