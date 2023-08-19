/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;

import java.util.List;

import static pro.tremblay.alljava.User.user;

/**
 * @author Henri Tremblay
 */
class TypeInference07 {

  // Just calculate and print directly...
  // Try with an array
  // Use the mustache

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
  void test1() {

    // print cat age per person
    users.stream()
      .forEach(person -> {
        String name = person.getName();
        int catAge = catAge(person);
        System.out.println(name + ": " + catAge); // doing two things!
      });
  }

  @Test
  void test2() {

    // print cat age per person
    users.stream()
      .map(person -> {
        String name = person.getName();
        int catAge = catAge(person);
        return new Object[] { name, catAge };
      })
      .forEach(a -> System.out.println(a[0] + ": " + a[1])); // and might need to cast
  }

  @Test
  void test3() {

    // print cat age per person
    users.stream()
      .map(person -> new Object() {
        String name = person.getName();
        int catAge = catAge(person);
      })
      .forEach(a -> System.out.println(a.name + ": " + a.catAge));
  }

}
