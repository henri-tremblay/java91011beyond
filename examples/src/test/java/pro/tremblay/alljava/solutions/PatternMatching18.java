/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

class PatternMatching18 {

  private Object foo() {
    return "aaa";
  }

  @Test
  void test() {
    Object obj = foo();
    if (obj instanceof String s) {
      System.out.println(s.length());
    }
  }

}
