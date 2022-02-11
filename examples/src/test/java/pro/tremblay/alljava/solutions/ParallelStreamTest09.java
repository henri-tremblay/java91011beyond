/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ParallelStreamTest09 {

  List<String> people = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  public void people() {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    threadLocal.set("super important value");

    List<String> result = people.stream()
      .parallel()
      .filter(name -> name.contains("i"))
      .peek(name -> System.out.println(Thread.currentThread().getName()))
      .peek(name -> System.out.println(threadLocal.get()))
      .collect(Collectors.toList());

    assertThat(result).hasSize(3);
  }

}
