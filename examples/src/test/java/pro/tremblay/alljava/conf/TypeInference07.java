/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;

import java.util.List;

import static pro.tremblay.alljava.User.user;

/**
 * @author Henri Tremblay
 */
class TypeInference07 {

  private static int catAge(User user) {
    return user.getAge() / 7;
  }

  List<User> users = List.of(
    user("Marc", 12),
    user("Pierre", 58),
    user("Jean", 40),
    user("Matthieu", 32)
  );

  @Test
  void test() {
    // print cat age per person
    users.stream()
      .forEach(person -> {
        String name = person.getName();
        int catAge = catAge(person);
        System.out.println(name + ": " + catAge);
      });
  }

}

// Run it
// Split in two
// Use an array
// Use an anonymous inner class
