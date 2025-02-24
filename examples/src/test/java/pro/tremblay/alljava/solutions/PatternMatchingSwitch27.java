/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

class PatternMatchingSwitch27 {

  @Test
  void test() {
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
    } else if (o == null) {
      formatted = "null";
    }
    return formatted;
  }

  static String formatter1(Object o) {
    return switch (o) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s  -> String.format("String %s", s);
      default        -> o.toString();
    };
  }

  static String formatter2(Object o) {
    return switch (o) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s  -> String.format("String %s", s);
      case null      -> "null";
      default        -> o.toString();
    };
  }

  static String formatter3(Object o) {
    return switch (o) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s when s.isEmpty() -> "empty";
      case String s when s.length() == 8 -> "empty";
      case String s -> String.format("String %s", s);
      case CharSequence c -> c.toString();
      case null      -> "null";
      default        -> o.toString();
    };
  }

  static void print(String s) {
    switch (s) {
      case null:
        System.out.println("null");
      default:
        System.out.println(s);
    }
  }
}
