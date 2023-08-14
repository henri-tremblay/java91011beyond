package pro.tremblay.alljava.conf;

import org.junit.Test;

public class DefaultCharset30 {

  @Test
  public void test() {
    System.out.println(System.getProperty("file.encoding"));
  }

  // Will be UTF-8 now, used to be cp1259 on Windows
}
