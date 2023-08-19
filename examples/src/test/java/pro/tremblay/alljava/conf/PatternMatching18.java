/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

class PatternMatching18 {

  private Object foo() {
    return "aaa";
  }

  @Test
  void test() {
    Object obj = foo();
    if (obj instanceof String) {
      System.out.println(((String) obj).length());
    }
  }

}

// pattern matching
// always true
