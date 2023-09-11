/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CodeSnippets32 {

  Map<String, String> map = new HashMap<>();

  /**
   * This is how a putIfAbsent works on a Map.
   * <pre>{@code
   * String s = map.putIfAbsent("key", "value");
   * if (s != null) {
   *   return s;
   * }
   * return "value";
   * }</pre>
   */
  @Test
  void test() {
  }

  // <pre>{@code
  // {@snippet ...}
  // {@snippet class="pro.tremblay.alljava.solutions.CodeSnippets32" region="example"}

}
