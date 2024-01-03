/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

class SerializableTest06 {

  // Show compilation error without casting
  // Cast in Runnable
  // Cast with Serializable
  // Serialize A
  // Show Writer Reader for bad classpath
  // Show Writer Reader for serialization in the same lambda

  @Test
  void test(@TempDir Path path) throws IOException, ClassNotFoundException {
    Path file = path.resolve("test.day");

    String hi = "Hello";
    A a = new A();
    try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
      out.writeObject((Runnable & Serializable) () -> System.out.println(a.str));
    }

    try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
      Runnable r = (Runnable) in.readObject();
      r.run();
    }
  }

  public static class A implements Serializable {
    String str = "AAA";
  }
}
