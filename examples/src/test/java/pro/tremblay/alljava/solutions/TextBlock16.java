/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.graalvm.polyglot.Context;
import org.junit.jupiter.api.Test;

// https://openjdk.java.net/jeps/368
class TextBlock16 {

  @Test
  void test() {
    String script = "function hello() {\n" +
      "    print('\"Hello, world\"');\n" +
      "}\n" +
      "\n" +
      "hello();\n";

    try (Context context = Context.create("js")) {
      context.eval("js", script);
    }
    System.out.println(script);
  }

  @Test
  void test1() {
    String script = """
                    function hello() {
                      print('"Hello, world\"');
                    }

                    hello();
                    """;

    try (Context context = Context.create("js")) {
      context.eval("js", script);
    }
    System.out.println(script);
  }

  @Test
  void test2() {
    String script = """
                    function hello() {
                      print('"Hello, $name"');
                    }

                    hello();
                    """.replace("$name", "Henri");

    try (Context context = Context.create("js")) {
      context.eval("js", script);
    }
    System.out.println(script);
  }

  @Test
  void test3() {
    String script = """
                    function hello() {
                      print('"Hello, %s"');
                    }

                    hello();
                    """.formatted("Henri");

    try (Context context = Context.create("js")) {
      context.eval("js", script);
    }
    System.out.println(script);
  }

  @Test
  void escaping() {

    // Escape character
    var tab = """
        a\tb""";
    System.out.println(tab);

    // Trailing whitespaces
    var trailing = """
        a   \s
        """;
    System.out.println("trailing");

    // Multiline
    var multiline = """
        this \
        is \
        a super long line""";
    System.out.println(multiline);

  }
}
