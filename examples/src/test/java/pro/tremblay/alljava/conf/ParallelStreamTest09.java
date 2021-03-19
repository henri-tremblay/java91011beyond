/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ParallelStreamTest09 {

  List<String> people = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  public void people() {
    List<String> result = people.stream()
      .filter(name -> name.contains("i"))
      .collect(Collectors.toList());

    assertThat(result).hasSize(3);
  }

}

// parallelStream and parallel
// commonPool
// peek thread name
// peel ThreadLocal
