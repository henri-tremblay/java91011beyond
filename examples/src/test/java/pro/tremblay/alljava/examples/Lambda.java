/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class Lambda {

  List<String> list = List.of("Henri");

  Map<String, String> map = Map.of("Henri", "Tremblay");

  private static String t(String name) {
    return name;
  }

  @Test
  public void test() {
    // One-liner, one arg
    list.stream()
      .map(name -> t(name))
      .forEach(name -> System.out.println(name));

    // Multiple arguments
    map.forEach((key, value) -> System.out.println(key + "=" + value));

    // Typed
    list.forEach((String e) -> System.out.println(e));

    // Multiline
    list.stream()
      .map(name -> {
        String result = t(name);
        return result;
      })
      .forEach(name -> {
        System.out.println(name);
      });

    // With closure
    String greeting= "Hello ";
    list.forEach(e -> System.out.println(greeting + e));
  }
}
