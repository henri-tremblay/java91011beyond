/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextBlock16 {

  @Test
  public void test() throws ScriptException {
    String script = "function hello() {\n" +
      "    print('\"Hello, world\"');\n" +
      "}\n" +
      "\n" +
      "hello();\n";

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
    engine.eval(script);

    System.out.println(script);
  }

  @Test
  public void escaping() {

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
