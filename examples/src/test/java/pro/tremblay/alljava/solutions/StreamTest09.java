/*
 * Copyright 2018-2019 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StreamTest09 {

  // forEach is not a stream
  // show the stream
  // show how to convert to a correct stream usage
  // extract method
  // return a stream


  List<String> people = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  public void people1() {
    List<String> result = new ArrayList<>();
    people.forEach(name -> {
      if(name.contains("i")) {
        result.add(name);
      }
    });

    assertThat(result).hasSize(3);
  }

  @Test
  public void people2() {
    List<String> result = new ArrayList<>();
    people.stream()
      .forEach(name -> {
        if(name.contains("i")) {
          result.add(name);
        }
      });

    assertThat(result).hasSize(3);
  }

  @Test
  public void people3() {
    List<String> result = people.stream()
      .filter(name -> name.contains("i"))
      .collect(Collectors.toList());

    assertThat(result).hasSize(3);
  }

  @Test
  public void people4() {
    List<String> result = names()
      .collect(Collectors.toList());

    assertThat(result).hasSize(3);
  }

  private Stream<String> names() {
    return people.stream()
      .filter(name -> name.contains("i"));
  }
}
