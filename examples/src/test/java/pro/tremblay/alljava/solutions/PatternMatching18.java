/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;

public class PatternMatching18 {

  private Object foo() {
    return "aaa";
  }

  @Test
  public void test() {
    Object obj = foo();
    if (obj instanceof String s) {
      System.out.println(s.length());
    }
  }

}
