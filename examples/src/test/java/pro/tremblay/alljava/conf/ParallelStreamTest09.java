/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class ParallelStreamTest09 {

  List<String> people = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  void people() {
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
