/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package lib;

import api.Hello;

public class HelloStdout implements Hello {

  private static String name = "world";

  @Override
  public void helloWorld() {
    System.out.printf("Hello %s!%n", name);
  }

}
