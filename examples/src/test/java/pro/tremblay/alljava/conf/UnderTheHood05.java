/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

class UnderTheHood05 {

  public static void main(String[] args) throws Exception {
    Arrays.asList(UnderTheHood05.class.getDeclaredMethods())
      .forEach(new Consumer<Method>() {
        @Override
        public void accept(Method method) {
          System.out.println(method.getName());
        }
      });
  }
}

// Run it
// Move to lambda
// Run it
// Use -verbose:class / -XX:+TraceClassLoading
// Run it
