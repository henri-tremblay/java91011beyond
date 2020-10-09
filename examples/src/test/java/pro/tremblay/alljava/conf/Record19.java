/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;
import pro.tremblay.alljava.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static pro.tremblay.alljava.User.user;

final class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    if(x < 0 || y < 0) {
      throw new IllegalArgumentException();
    }
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x &&
      y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

public class Record19 {

  @Test
  public void test() {
    var p = new Point(3,4);

    System.out.println(p);
    System.out.println(p.x());
    System.out.println(p.y());

    var q = new Point(3, 4);

    assertThat(p).isEqualTo(q);
    assertThat(p.hashCode()).isEqualTo(q.hashCode());
    assertThat(p.toString()).isEqualTo("(3, 4)");
  }

  private static int catAge(User user) {
    return user.getAge() * 7;
  }

  List<User> users = List.of(
    user("Marc", 12),
    user("Pierre", 58),
    user("Jean", 40),
    user("Matthieu", 32)
  );

  @Test
  public void testTuple() {
    // print cat age per person
    var list = users.stream()
      .map(person -> new Object() {
        String name = person.getName();
        int catAge = catAge(person);
      })
      .collect(Collectors.toList());

    System.out.println(list.get(0).name);
  }
}

// Immutable
// Final
// Can add and override methods
// No fields can be added (apart from static ones)
// Replace anonymous with record
// Type with the record
// Show bytecode
