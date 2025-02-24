/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

public class UnnamedPatterns38 {

  sealed interface Numeric permits Amount, Quantity {
    BigDecimal value();
    default int precision() {
      return switch (this) {
        case Amount _ -> 2;
        case Quantity _ -> 0;
      };
    }
  }
  record Amount(BigDecimal value) implements Numeric {}
  record Quantity(BigDecimal value) implements Numeric {}

  @Test
  void test() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException _) {

    }

    Function<String, Integer> f = _ -> 2;
  }
}
