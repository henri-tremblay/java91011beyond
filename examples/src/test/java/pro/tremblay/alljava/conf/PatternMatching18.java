/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

public class PatternMatching18 {

  private Object foo() {
    return "aaa";
  }

  @Test
  public void test() {
    Object obj = foo();
    if (obj instanceof String) {
      System.out.println(((String) obj).length());
    }
  }

}
