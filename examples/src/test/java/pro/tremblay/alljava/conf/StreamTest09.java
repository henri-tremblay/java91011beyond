/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StreamTest09 {

  List<String> people = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  public void people() {
    List<String> result = new ArrayList<>();

    people.forEach(name -> {
      if(name.contains("i")) {
        result.add(name);
      }
    });

    assertThat(result).hasSize(3);
  }
}

// Not a stream
// Convert to stream and pipeline
// Extract method
// Return stream
