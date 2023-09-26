/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.SequencedCollection;
import java.util.stream.Collectors;

public class SequencedCollection36 {

  @Test
  public void test() {
    SequencedCollection<String> list = List.of("I", "love", "Java");
    list.addFirst("Sure,");
    printList(list);
    list.reversed();
    printList(list);
  }

  private void printList(SequencedCollection<String> list) {
    System.out.println(list.stream().collect(Collectors.joining(" ")));
  }
}
