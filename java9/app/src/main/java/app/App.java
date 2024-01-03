/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package app;

import lib.Hello;
import lib.HelloStdout;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class App {
  public static void main(String... args) throws Throwable {
    System.out.println("Module: " + App.class.getModule().getName());
    System.out.println("Module: " + Hello.class.getModule().getName());
    System.out.println("Module: " + String.class.getModule().getName());

    MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(HelloStdout.class, MethodHandles.lookup());
    MethodHandle mh = lookup.findStaticSetter(HelloStdout.class, "name", String.class);
    mh.invokeExact("Henri");

    Hello hello = new HelloStdout();
    hello.helloWorld();

//    ServiceLoader<Hello> serviceLoader = ServiceLoader.load(Hello.class);
//    serviceLoader.findFirst().ifPresent(Hello::helloWorld);
  }
}
