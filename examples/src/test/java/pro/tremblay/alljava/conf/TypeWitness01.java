/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class TypeWitness01 {

  @Test
  void test() {
//    foo(EasyMock.anyObject());
  }

  private void foo(List<String> list) {

  }

  private void foo(Set<String> set) {
    Assertions.fail("Wrong method called");
  }
}

// Uncomment
// Cast to List<String>
// Use the type witness
