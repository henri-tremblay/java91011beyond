/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * - Replace by VarHandle
 */
public class UseVarHandle {

  private String name = "JavaOne";

  public void hello() {
    System.out.println("Hello " + name);
  }

  @Test
  public void testMethodHandle() throws Throwable {
    MethodHandle mh = MethodHandles.lookup().findSetter(getClass(), "name", String.class);
    mh.invokeExact(this, "Oracle Code One");
    hello();
  }

  @Test
  public void testVarHandle() throws Throwable {
    VarHandle mh = MethodHandles.lookup().findVarHandle(getClass(), "name", String.class);
    mh.set(this, "Oracle Code One");
    hello();
  }

}
