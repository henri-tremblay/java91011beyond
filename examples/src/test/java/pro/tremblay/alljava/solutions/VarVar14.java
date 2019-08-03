/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;
import pro.tremblay.alljava.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.tremblay.alljava.User.user;

/**
 * - Collect to list
 * - Show that we can't access attributes
 * - Change to var
 * - Show that now we can
 * - Type the lambda, annotate
 */
public class VarVar14 {

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ ElementType.PARAMETER})
  public @interface NotNull {
  }

  Map<Long, User> persons = Map.of(
    1L, user("Marc", 12),
    2L, user("Pierre", 58),
    3L, user( "Jean", 40),
    4L, user("Matthieu", 32)
  );

  @Test
  public void test1() {
    persons.entrySet().stream()
      .map(entry -> new Object() {
        long id =  entry.getKey();
        String name = entry.getValue().getName();
      })
      .collect(Collectors.toList());
  }

  @Test
  public void test2() {
    List<Object> result = persons.entrySet().stream()
      .map(entry -> new Object() {
        long id =  entry.getKey();
        String name = entry.getValue().getName();
      })
      .collect(Collectors.toList());
  }

  @Test
  public void test3() {
    var result = persons.entrySet().stream()
      .map(entry -> new Object() {
        long id =  entry.getKey();
        String name = entry.getValue().getName();
      })
      .collect(Collectors.toList());

    System.out.println(result.get(0).name);
  }

  @Test
  public void test4() {
    var result = persons.entrySet().stream()
      .map((@NotNull  Map.Entry<Long, User> entry) -> new Object() {
        long id =  entry.getKey();
        String name = entry.getValue().getName();
      })
      .collect(Collectors.toList());

    System.out.println(result.get(0).name);
  }
}

// Assign to List<Object>
// Assign to var

// Java 11:
// var in lambda
