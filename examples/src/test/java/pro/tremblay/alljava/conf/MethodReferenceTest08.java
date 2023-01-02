/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class MethodReferenceTest08 {

  @Test
  public void test() {
    String s = null;
    IntSupplier r = () -> s.length();
  }

}

// Run it
// Replace with method reference
// Run it
