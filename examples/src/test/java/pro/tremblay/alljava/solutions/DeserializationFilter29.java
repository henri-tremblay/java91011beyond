/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.Event;
import pro.tremblay.alljava.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputFilter;
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
    }
    System.out.println(user + " " + event);
  }

  @Test
  void test1() throws Exception {
    User user = User.user("Jesus", 33);
    Event event = Event.create("Resurrection");

    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    try(ObjectOutputStream out = new ObjectOutputStream(bOut)) {
      out.writeObject(event);
      out.writeObject(user);
    }
    try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bOut.toByteArray()))) {
      in.setObjectInputFilter(filterInfo -> filterInfo.serialClass() == User.class ?
        ObjectInputFilter.Status.ALLOWED : ObjectInputFilter.Status.REJECTED);
      event = (Event) in.readObject();
      user = (User) in.readObject();
    }
    System.out.println(user + " " + event);
  }

  @Test
  void test2() throws Exception {
    User user = User.user("Jesus", 33);
    Event event = Event.create("Resurrection");

    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    try(ObjectOutputStream out = new ObjectOutputStream(bOut)) {
      out.writeObject(event);
      out.writeObject(user);
    }

    ObjectInputFilter.Config.setSerialFilterFactory((currentFilter, nextFilter) -> {
      if(currentFilter == null && nextFilter != null) {
        return nextFilter;
      }
      if(nextFilter == null) {
        return currentFilter;
      }
      return ObjectInputFilter.merge(currentFilter, nextFilter);
    });

    try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bOut.toByteArray()))) {
      in.setObjectInputFilter(filterInfo -> ObjectInputFilter.Status.ALLOWED);
      event = (Event) in.readObject();
      user = (User) in.readObject();
    }
    System.out.println(user + " " + event);
  }

}

