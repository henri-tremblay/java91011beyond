/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package lib;

import org.junit.Test;

public class HelloTest {

  private final Hello hello = new Hello();

  @Test
  public void testApp() {
    hello.helloWorld();
  }

}
