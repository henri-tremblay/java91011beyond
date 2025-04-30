/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;

import java.util.List;
import java.util.stream.Gatherer;

import static pro.tremblay.alljava.User.user;

public class StreamGatherers44 {

  private static int catAge(User user) {
    return user.getAge() / 7;
  }

  List<User> users = List.of(
    user("Marc", 12),
    user("Pierre", 58),
    user("Jean", 40),
    user("Matthieu", 32)
  );

  record CatAge(String name, int age) {}

  @Test
  void test() {
    users.stream()
      .map(user -> new CatAge(user.getName(), catAge(user)))
      .forEach(System.out::println);
  }

  @Test
  void test1() {
    users.stream()
      .gather(gatherCatAge())
      .forEach(System.out::println);
  }

  private static Gatherer<User, Void, Object> gatherCatAge() {
    return Gatherer.of((_, user, downstream) -> {
        downstream.push(new CatAge(user.getName(), catAge(user)));
        return true;
      }
    );
  }
}
