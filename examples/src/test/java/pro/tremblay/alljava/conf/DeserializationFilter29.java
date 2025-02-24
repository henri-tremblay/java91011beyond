/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.Event;
import pro.tremblay.alljava.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class DeserializationFilter29 {

  @Test
  void test() throws Exception {
    User user = User.user("Jesus", 33);
    Event event = Event.create("Resurrection");

    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    try(ObjectOutputStream out = new ObjectOutputStream(bOut)) {
      out.writeObject(event);
      out.writeObject(user);
    }
    try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bOut.toByteArray()))) {
      event = (Event) in.readObject();
      user = (User) in.readObject();
      System.out.println(user + " " + event);
    }
  }

}
// Java 9 filter JSR 290
// -Djdk.serialFilter=!pro.tremblay.alljava.User
// in.setObjectInputFilter
// both at the same time
// ObjectInputFilter.Config.setSerialFilterFactory
// -Djdk.serialFilterFactory=OVERRIDE
