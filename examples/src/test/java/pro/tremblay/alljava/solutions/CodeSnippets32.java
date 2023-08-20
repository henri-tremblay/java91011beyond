/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CodeSnippets32 {

  Map<String, String> map = new HashMap<>();

  public void hello(String name) {
    System.out.println("Hello");
  }

  /**
   * This is how a putIfAbsent works on an Map.
   * <pre>{@code
   * String s = map.putIfAbsent("key", "value");
   * if (s != null) {
   *   return s;
   * }
   * return "value";
   * }</pre>
   */
  @Test
  public void test() {
  }

  /**
   * This is how a putIfAbsent works on an Map.
   * {@snippet :
   * String s = map.putIfAbsent("key", "value");
   * if (s != null) {
   *   return s;
   * }
   * return "value";
   * }
   */
  @Test
  public void test1() {
  }

  /**
   * This is how a putIfAbsent works on an Map.
   * {@snippet class="pro.tremblay.alljava.solutions.CodeSnippets32" region="example"}
   */
  @Test
  public void test2() {

  }

  String howPutIfAbsentWorks() {
    // @start region="example"
    String s = map.putIfAbsent("key", "value");
    if (s != null) {
      return s;
    }
    return "value";
    // @end
  }
}
