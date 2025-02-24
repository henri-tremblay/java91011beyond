/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

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
    list = list.reversed();
    printList(list);
  }

  private void printList(SequencedCollection<String> list) {
    System.out.println(String.join(" ", list));
  }
}
