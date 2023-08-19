/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Henri Tremblay
 */
public class Java11 {

  private Map<String, String> map = new HashMap<>();
  {
    map.put("key", "value");
  }

  @SuppressWarnings("unchecked")
  @Test
  public void testHashtable() {
    Hashtable map = new Hashtable() {{
      put("key", "value");
    }};
  }

  @Test
  public void testMap() {
    Map<String, String> map = new HashMap<>() {{
      put("key", "value");
    }};
  }

  @Test
  public void testMapOf() {
    Map<String, String> map = Map.of("key", "value");
  }

  @Test
  public void testUnmodifiable() {
    Map<String, String> map = new HashMap<>();
    map.put("key", "value");
    map = Collections.unmodifiableMap(map);
    map.put("key", "value");
  }
}
