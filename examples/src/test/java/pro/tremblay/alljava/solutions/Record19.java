/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;
import pro.tremblay.alljava.User;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static pro.tremblay.alljava.User.user;

record Point(int x, int y) {

  public Point {
    if(x < 0 || y < 0) {
      throw new IllegalArgumentException();
    }
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
    record PersonAsCat(String name, int catAge) {}

    List<PersonAsCat> result = users.stream()
      .map(user -> new PersonAsCat(user.getName(), catAge(user)))
      .collect(Collectors.toList());

    System.out.println(result.get(0).name);
  }
}
