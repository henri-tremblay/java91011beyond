/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import pro.tremblay.alljava.User;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.tremblay.alljava.User.user;

/**
 * @author Henri Tremblay
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
  public void test() {

    persons.entrySet().stream()
      .map(entry -> new Object() {
        long id =  entry.getKey();
        String name = entry.getValue().getName();
      })
      .collect(Collectors.toList());
  }
}

// Assign to List<Object>
// Assign to var

// Java 11:
// var in lambda
