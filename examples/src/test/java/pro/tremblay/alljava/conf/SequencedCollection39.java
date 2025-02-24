/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class SequencedCollection39 {

  @Test
  public void test() {
    SequencedCollection<String> list = new ArrayList<>(List.of("I", "love", "Java"));
    list.addFirst("Sure,");
    printList(list);
    list.reversed();
    printList(list);
  }

  private void printList(SequencedCollection<String> list) {
    System.out.println(String.join(" ", list));
  }
}

// show new methods quickly
// reverse doesn't reverse
// show the interface
// SequencedSet, SequenceMap, ...
