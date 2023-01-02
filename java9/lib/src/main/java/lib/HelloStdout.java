/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package lib;

public class HelloStdout implements Hello {

  private static String name = "world";

  @Override
  public void helloWorld() {
    System.out.printf("Hello %s!%n", name);
  }

}
