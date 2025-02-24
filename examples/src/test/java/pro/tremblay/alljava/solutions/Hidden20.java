/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

class Hidden20 {

  @Test
  void test() throws ClassNotFoundException {

    Runnable r = () -> {
      throw new RuntimeException("Error!");
    };

    System.out.println(r.getClass().isHidden());
    System.out.println(r.getClass().getClassLoader());

    Class<?> clazz = Class.forName(r.getClass().getName());
    r.run();

  }

}

// Run it
// Talk about hidden
// -XX:+UnlockDiagnosticVMOptions -XX:+ShowHiddenFrames
// MethodHandles.lookup().defineHiddenClass() replaces Unsafe.defineAnonymousClass
