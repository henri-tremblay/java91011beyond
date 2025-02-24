/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

class DefaultCharset30 {

  @Test
  void test() {
    System.out.println(System.getProperty("file.encoding"));
  }

  // Will be UTF-8 now, used to be cp1252 on Windows
  // -Dfile.encoding=COMPAT
}
