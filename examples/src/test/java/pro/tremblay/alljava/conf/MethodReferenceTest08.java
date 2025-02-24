/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

class MethodReferenceTest08 {

  @Test
  void test() {
    String s = null;
    IntSupplier r = () -> s.length();
  }

}

// Run it
// Replace with method reference
// Run it
