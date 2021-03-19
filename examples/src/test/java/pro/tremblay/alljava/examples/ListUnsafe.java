/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import sun.misc.Unsafe;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author Henri Tremblay
 */
public class ListUnsafe {
   public static void main(String[] args) {
      Arrays.stream(Unsafe.class.getDeclaredMethods())
          .filter(m -> Modifier.isPublic(m.getModifiers()))
          .map(Method::getName)
          .distinct()
          .sorted()
//          .map(m -> m.toString())
//              .replace("sun.misc.Unsafe.", "")
//              .replace("public ", "")
//              .replace("native ", "")
//              .replace("final ", "'")
//              .replace("java.lang.", ""))
         .forEach(System.out::println);
   }
}
