/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TypeWitness01 {

  @Test
  public void test() {
//    foo(EasyMock.anyObject());
  }

  private void foo(List<String> list) {

  }

  private void foo(Set<String> set) {
    fail("Wrong method called");
  }
}

// Uncomment
// Cast to List<String>
// Use the type witness
