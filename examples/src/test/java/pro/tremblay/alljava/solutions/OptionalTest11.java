/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import pro.tremblay.alljava.User;
import pro.tremblay.alljava.UserDao;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class OptionalTest11 {

  // Do a lambda filter findAny
  // Get it, show it fails
  // isPresent
  // Map and ifPresent
  // Optional.ofNullable
  // orElse

  List<String> list = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  void findHenriAndPrintIt() {
    int i = list.indexOf("Henri");
    if(i >= 0) {
      String henri = list.get(i);
      System.out.println(henri);
    }
  }

  @Test
  void findHenriLambdaStyle() {
    Optional<String> result = list.stream()
      .filter("Henri"::equals)
      .findAny();

    if(result.isPresent()) {
      System.out.println(result.get());
    }
  }

  @Test
  void findHenriLambdaStyleCute() {
    list.stream()
      .filter("Henri"::equals)
      .findAny()
      .map(s -> "Sir Henri")
      .ifPresent(System.out::println);
  }

  @Test
  void orElse() {
    UserDao dao = new UserDao();
    User user = dao.find("Henri");
    if(user == null) {
      System.out.println("404");
    }
    else {
      System.out.println(user.getName());
    }
  }

  @Test
  void orElseCute() {
    UserDao dao = new UserDao();
    String result = Optional.ofNullable(dao.find("Roger"))
      .map(User::getName)
      .orElse("404");
    System.out.println(result);
  }

  @Test
  void orElseCute2() {
    UserDao dao = new UserDao();
    Optional.ofNullable(dao.find("Roger"))
      .map(User::getName)
      .ifPresentOrElse(System.out::println, () -> System.out.println("404"));
  }
}
