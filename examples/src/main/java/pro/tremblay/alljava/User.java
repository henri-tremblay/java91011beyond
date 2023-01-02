/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

  private final String name;
  private final int age;

  public static User user(String name, int age) {
    return new User(name, age);
  }

  private User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) { return true; }
    if(o == null || getClass() != o.getClass()) { return false; }

    User user = (User) o;

    return name.equals(user.name);

  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(User o) {
    return name.compareTo(o.name);
  }
}

