/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Henri Tremblay
 */
public class OrientedObject {

  @Test
  public void test() {
    int a = 3, b = 4;

    double c = Math.sqrt(IntStream.of(a, b)
      .map(i -> pow(i, 2))
      .sum());

    assertThat(c).isEqualTo(5);
  }

  private static int pow(int base, int exponent) {
    int result = 1;
    for(int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }
}
