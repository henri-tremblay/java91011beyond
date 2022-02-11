/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

  public static final List<String> NAMES = List.of("Henri", "Matthieu", "Anthony", "Chris");

  private final Map<String, User> map = new HashMap<>(4);

  public UserDao() {
    int[] age = { 30 };
    NAMES.forEach(s -> {
      map.put(s, User.user(s, age[0]));
      age[0] += 2;
    });
  }

  public User find(String firstName) {
    return map.get(firstName);
  }
}
