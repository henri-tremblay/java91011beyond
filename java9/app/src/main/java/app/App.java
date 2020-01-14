/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package app;

import lib.Hello;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public class App {
  public static void main(String... args) throws Throwable {
    MethodHandle mh = MethodHandles.privateLookupIn(Hello.class, MethodHandles.lookup())
      .findStaticSetter(Hello.class, "name", String.class);
    mh.invokeExact("Henri");

    Hello.helloWorld();
  }
}

// --add-opens pro.tremblay.java9.lib/lib=pro.tremblay.java9.app
