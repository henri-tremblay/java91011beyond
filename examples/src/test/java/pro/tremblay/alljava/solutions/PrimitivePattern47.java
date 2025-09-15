/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimitivePattern47 {

  record Failure(int status) {}

  @Test
  void test() {
    Failure failure = new Failure(404);
    String message = switch (failure.status()) {
      case 200 -> "OK";
      case 404 -> "Not found";
      default -> "Unknown status";
    };
    assertThat(message).isEqualTo("Not found");
  }

  @Test
  void test1() {
    Failure failure = new Failure(200);
    String message = switch (failure.status()) {
      case 200 -> "OK";
      case 404 -> "Not found";
      case int i -> "Unknown status " + i;
    };
    assertThat(message).isEqualTo("OK");
  }

  @Test
  void test2() {
    Failure failure = new Failure(200);
    String message = switch (failure.status()) {
      case 200 -> "OK";
      case 404 -> "Not found";
      case int i when i > 200 && i < 300 -> "OK with unknown status " + i;
      case int i -> "Unknown status " + i;
    };
    assertThat(message).isEqualTo("OK");
  }

  @Test
  void test3() {
    assertThat(15 instanceof int).isTrue();
    assertThat(15 instanceof float).isTrue();
    assertThat(15.2f instanceof int).isFalse();
    assertThat(1024 instanceof byte).isFalse();
  }

}

// default to int i
// when 200
// instanceof primitive
