package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateProcessor37 {

  @Test
  void test() {
    String name = "Henri";
    String script = STR."""
                    function hello() {
                      print('Hello, \{name}');
                    }

                    hello();
                    """;

    assertThat(script).contains(name);
  }

}
