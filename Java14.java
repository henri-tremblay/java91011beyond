/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

public class Java14 {

  public static class A {
    private String value;

    public String getValue() {
      return value;
    }
  }

  public static void main(String[] args) {
    A a = new A();
    System.out.println(a.getValue().length());
  }
}

//  -XX:+ShowCodeDetailsInExceptionMessages
