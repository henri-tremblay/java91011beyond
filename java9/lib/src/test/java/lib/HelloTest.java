/*
 * Copyright 2018-2026 Henri Tremblay.
 */
package lib;

import api.Hello;
import org.junit.jupiter.api.Test;

class HelloTest {

  private final Hello hello = new HelloStdout();

  @Test
  void testApp() {
    hello.helloWorld();
  }

}
