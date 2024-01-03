/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class SerializableTest06 {

  @Test
  void test(@TempDir Path path) throws IOException, ClassNotFoundException {
    Path file = path.resolve("test.day");

    try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
      out.writeObject((Runnable) () -> System.out.println("Test"));
    }

    try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
      Runnable r = (Runnable) in.readObject();
      r.run();
    }
  }

  public static class A {
    String str = "AAA";
  }
}

// Run it
// Make it serializable
// Run it
// Replace with A in closure
// Run it
// Make it serializable
