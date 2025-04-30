/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarkdownDoc42 {

    /// Add first to second parameter.
    /// Tested in [test()][#test()]
    ///
    /// ```
    /// int c = add(a, b);
    /// ```
    ///
    /// @param a first value
    /// @param b second value
    /// @return sum of the two parameters
    public int add(int a, int b) {
    return a + b;
  }

  @Test
  void test() {
    assertThat(add(10, 2)).isEqualTo(12);
  }

}

// Move to markdown
