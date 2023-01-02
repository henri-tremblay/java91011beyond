/*
 * Copyright 2018-2023 Henri Tremblay.
 */
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Writer {

  public static void main(String[] args) throws IOException {
    try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("../test.txt")))) {
      out.writeObject((Runnable & Serializable) () -> System.out.println("Test"));
    }
  }
}
