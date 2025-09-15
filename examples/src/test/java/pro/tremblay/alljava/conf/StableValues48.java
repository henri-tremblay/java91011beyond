/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StableValues48 {

  private static final StableValues48 instance = new StableValues48();

  public static StableValues48 getInstance() {
    return instance;
  }

  private StableValues48() {}

  @Test
  void test() throws Throwable {
    StableValues48 instance = StableValues48.getInstance();
    assertThat(instance).isNotNull();
  }
}

// double-checked locking
// Stable orElseSet
// Stable supplier
