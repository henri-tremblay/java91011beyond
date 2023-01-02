/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.lang.reflect.Field;

public class Jpms26 {

  @Test
  public void test() throws Exception {
    String s = "Test";
    Field field = String.class.getDeclaredField("value");
    field.setAccessible(true);
    byte[] value = (byte[]) field.get(s);
    value[0] = 'B';
    System.out.println(s);
  }

}
// --illegal-access=permit deny warn
// --add-opens java.base/java.lang=ALL-UNNAMED
