/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableTest06 {

  // Show compilation error without casting
  // Cast in Runnable
  // Cast with Serializable
  // Serialize A
  // Show Writer Reader for bad classpath
  // Show Writer Reader for serialization in the same lambda

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  Path path;

  @Before
  public void setup() throws IOException {
    path = folder.newFile().toPath();
  }

  @Test
  public void test() throws IOException, ClassNotFoundException {
    String hi = "Hello";
    A a = new A();
    try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
      out.writeObject((Runnable & Serializable) () -> System.out.println(a.str));
    }

    try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
      Runnable r = (Runnable) in.readObject();
      r.run();
    }
  }

  public static class A {
    String str = "AAA";
  }
}
