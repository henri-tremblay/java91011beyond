/*
 * Copyright 2018-2022 Henri Tremblay.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

interface MyInterface {
  void run();
}

public class Reader {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("../test.txt")))) {
      MyInterface r = (MyInterface) in.readObject();
      r.run();
    }
  }
}
