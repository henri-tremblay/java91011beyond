import java.math.BigDecimal;

public class Java21 {

  public static void main(String[] args) {
    String name = "Henri";
    String script = STR."""
                    function hello() {
                      print('Hello, \{name.length()}');
                    }

                    hello();
                    """;

    System.out.println(script);
  }

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

  // template processor STR.
  // java --enable-preview --source 21 Java21.java
  // name.length()

  // Thread.sleep(1000); with _
  // Underscore in precision

  // remove public
  // remove args
  // remove static
  // remove class
}
