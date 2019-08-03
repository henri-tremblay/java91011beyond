/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodHandles04 {

  private String title = "Mr.";

  public void hello(String name) {
    System.out.println("Hello " + title + " " + name);
  }

  @Test
  public void test() throws Throwable {
    Field field = MethodHandles04.class.getDeclaredField("title");
    field.setAccessible(true);
    field.set(this, "Sir");

    Method method = MethodHandles04.class.getMethod("hello", String.class);
    method.invoke(this, "Henri");
  }

  @Test
  public void testPrivate() throws Throwable {
    List<String> list = new ArrayList<>();

    MethodHandle getter = MethodHandles.lookup().findGetter(ArrayList.class, "size", int.class);
    System.out.println(getter.invokeExact(list));
  }
}

// Show the different solutions
