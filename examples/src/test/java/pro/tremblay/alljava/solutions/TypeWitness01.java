/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TypeWitness01 {

  // Not compiling
  // Show with cast to list
  // Show with type witness

  @Test
  public void test() {
    foo(EasyMock.<List<String>>anyObject());
  }

  private void foo(List<String> list) {

  }

  private void foo(Set<String> set) {
    fail("Wrong method called");
  }
}
