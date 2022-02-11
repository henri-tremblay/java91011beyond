/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

public class PatternMatchingSwitch27 {

  @Test
  public void test() {
    System.out.println(formatter(1));
    System.out.println(formatter(1L));
    System.out.println(formatter(1.0));
    System.out.println(formatter("Henri"));
    System.out.println(formatter(""));
    System.out.println(formatter(null));
  }

  static String formatter(Object o) {
    String formatted = "unknown";
    if (o instanceof Integer i) {
      formatted = String.format("int %d", i);
    } else if (o instanceof Long l) {
      formatted = String.format("long %d", l);
    } else if (o instanceof Double d) {
      formatted = String.format("double %f", d);
    } else if (o instanceof String s) {
      formatted = String.format("String %s", s);
    }
    return formatted;
  }
}

// switch case Integer i ->
// case null
// && s.isEmpty()
