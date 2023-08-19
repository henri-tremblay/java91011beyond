/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * - Use unreflect (method than field)
 * - Replace by a MethodHandle
 * - Show field accessible with unreflect
 * - Show field accessible with privateLookupIn
 */
public class MethodHandles04 {

  private String title = "Mr.";

  public void hello(String name) {
    System.out.println("Hello " + title + " " + name);
  }

  @Test
  void test() throws Throwable {
    Field field = MethodHandles04.class.getDeclaredField("title");
    MethodHandle setter = MethodHandles.lookup().unreflectSetter(field);
    setter.invokeExact(this, "Sir");

    Method method = MethodHandles04.class.getMethod("hello", String.class);
    MethodHandle mh = MethodHandles.publicLookup().unreflect(method);
    mh.invokeExact(this, "Henri");
  }

  @Test
  void test1() throws Throwable {
    MethodHandle setter = MethodHandles.lookup().findSetter(getClass(), "title", String.class);
    setter.invokeExact(this, "Sir");

    MethodType mt = MethodType.methodType(void.class, String.class);
    MethodHandle mh = MethodHandles.publicLookup().findVirtual(getClass(), "hello", mt);
    mh.invokeExact(this, "Henri");
  }

  @Test
  void test2() throws Throwable {
    MethodHandle setter = MethodHandles.lookup().findSetter(ArrayList.class, "size", int.class);
    setter.invokeExact(this);
  }

  @Test
  void test3() throws Throwable {
    List<String> list = new ArrayList<>();

    Field field = ArrayList.class.getDeclaredField("size");
    field.setAccessible(true);
    MethodHandle getter = MethodHandles.lookup().unreflectGetter(field);
    System.out.println(getter.invoke(list));
  }

  @Test
  void test4() throws Throwable {
    List<String> list = new ArrayList<>();

    MethodHandle getter = MethodHandles.privateLookupIn(ArrayList.class, MethodHandles.lookup()).findGetter(ArrayList.class, "size", int.class);
    System.out.println(getter.invoke(list));
  }
}
