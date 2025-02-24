/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import java.lang.reflect.Method;
import java.util.Arrays;

class UnderTheHood05 {

  // Show the target dir
  // Move to lambda
  // Show the target dir
  // Run the program
  // Use -XX:+TraceClassLoading

  public static void main(String[] args) throws Exception {
    Arrays.asList(UnderTheHood05.class.getDeclaredMethods())
      .forEach(method -> System.out.println(method.getName()));

    System.out.println("#####");

    Method method = UnderTheHood05.class.getDeclaredMethod("lambda$main$0", Method.class);
    method.setAccessible(true);
    method.invoke(null, method);

    // if(user.hasAccess()) {
    //    foo(user -> things);
    // }
  }
}
