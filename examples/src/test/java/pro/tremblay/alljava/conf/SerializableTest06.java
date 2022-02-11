/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializableTest06 {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  Path path;

  @Before
  public void setup() throws IOException {
    path = folder.newFile().toPath();
  }

  @Test
  public void test() throws IOException, ClassNotFoundException {
    try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
      out.writeObject((Runnable) () -> System.out.println("Test"));
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

// Run it
// Make it serializable
// Run it
// Replace with A in closure
// Run it
// Make it serializable
