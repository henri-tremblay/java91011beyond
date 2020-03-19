/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class VarKeyword13 {

  @Test
  public void test() {
    ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
    map.put("key", "value");
    String key = map.get("key");
  }
}

// Use var
// var is not a keyword
// Doesn't compile because of the diamond, type is inferred down
// Type of the concrete class, not the interface
