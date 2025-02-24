/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package lib;

import org.junit.jupiter.api.Test;

class HelloTest {

  private final Hello hello = new HelloStdout();

  @Test
  void testApp() {
    hello.helloWorld();
  }

}
