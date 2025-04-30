/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownDoc42 {

  /**
   * Add first to second parameter.
   * Tested in {@link MarkdownDoc42#test()}
   * <pre>{@code
   * int c = add(a, b);
   * }</pre>
   * @param a first value
   * @param b second value
   * @return sum of the two parameters
   */
  public int add(int a, int b) {
    return a + b;
  }

  @Test
  void test() {
    assertThat(add(10, 2)).isEqualTo(12);
  }

}

// Move to markdown
// links
// code
