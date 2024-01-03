/*
 * Copyright 2018-2024 Henri Tremblay.
 */
import java.math.BigDecimal;

void main() {
  String name = "Henri";
  String script = STR."""
                  function hello() {
                    print('Hello, \{name.length()}');
                  }

                  hello();
                  """;

  try {
    Thread.sleep(1000);
  } catch (InterruptedException _) {

  }

  System.out.println(script);
  System.out.println(new Amount(BigDecimal.valueOf(10.0)).precision());
}

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
