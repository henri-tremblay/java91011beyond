/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateProcessor37 {

  @Test
  void test() {
    String name = "Henri";
    String script = """
                    function hello() {
                      print('Hello, ${name}');
                    }

                    hello();
                    """.replace("${name}", name);

    assertThat(script).contains(name);
  }

}

// template processor STR.
// java --enable-preview --source 21 Java21.java
// name.length()
