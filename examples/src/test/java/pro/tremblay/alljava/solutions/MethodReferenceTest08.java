/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

/**
 * - See that it works
 * - Replace with method reference
 * - Show the NullPointerException
 */
class MethodReferenceTest08 {

  @Test
  void test() {
    String s = null;
    IntSupplier r = s::length;
  }
}
