package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

public class UnnamedPatterns38 {

  sealed interface Numeric permits Amount, Quantity {
    BigDecimal value();
    default int precision() {
      return switch (this) {
        case Amount a -> 2;
        case Quantity q -> 0;
      };
    }
  }
  record Amount(BigDecimal value) implements Numeric {}
  record Quantity(BigDecimal value) implements Numeric {}

  @Test
  void test() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {

    }

    Function<String, Integer> f = unused -> 2;
  }
}

// Pattern with _
// Thread.sleep(1000); with _
// lambda with _
