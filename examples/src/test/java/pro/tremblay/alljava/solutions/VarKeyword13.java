/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * - Replace by var
 * - Explain that var is not a keyword
 * - Doesn't compile because of the diamond
 * - Type of the concrete class, not the interface
 */
class VarKeyword13 {

  @Test
  void test() {
    var map = new ConcurrentHashMap<String, String>();
    map.put("key", "value");
    String key = map.get("key");

    System.out.println(map.mappingCount());
  }

}
