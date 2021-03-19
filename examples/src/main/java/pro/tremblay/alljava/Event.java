/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava;

import java.util.HashSet;
import java.util.Set;

public class Event {

  private Set<User> users = new HashSet<>();

  private String name;

  private Event(String name) {
    this.name = name;
  }

  public static Event create(String name) {
    return new Event(name);
  }

  public String getName() {
    return name;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public Set<User> getUsers() {
    return users;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) { return true; }
    if(o == null || getClass() != o.getClass()) { return false; }

    Event event = (Event) o;

    return name.equals(event.name);

  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return name;
  }
}
