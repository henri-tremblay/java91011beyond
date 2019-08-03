/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

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
  }

  @Test
  public void test1() throws ScriptException {
    String script = """
                    function hello() {
                      print('"Hello, world\"');
                    }

                    hello();
                    """;
    System.out.println(script);
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
    engine.eval(script);
  }

  @Test
  public void test2() throws ScriptException {
    String script = """
                    function hello() {
                      print('"Hello, $name"');
                    }

                    hello();
                    """.replace("$name", "Henri");
    System.out.println(script);
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
    engine.eval(script);
  }

  @Test
  public void test3() throws ScriptException {
    String script = """
                    function hello() {
                      print('"Hello, %s"');
                    }

                    hello();
                    """.formatted("Henri");
    System.out.println(script);
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
    engine.eval(script);
  }
}
