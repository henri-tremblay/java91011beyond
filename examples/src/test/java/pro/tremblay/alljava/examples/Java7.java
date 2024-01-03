/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Henri Tremblay
 */
public class Java7 {

  List<String> list = new ArrayList<>();
  int i = 0b00100100;
  int j = 1_000_000;

  public String switchString(String s) {
    switch(s) {
      case "hello":
        return "world";
      case "bonjour":
        return "le monde";
    }
    return null;
  }

  public void test() throws Exception {
    InputStream in = new FileInputStream("allo.txt");
    try {
      // … do stuff
      in.close();
    } catch(IOException e) {
      try {
        in.close();
      } catch(IOException e1) {
        e.addSuppressed(e1);
      }
      throw e;
    }
  }
}
