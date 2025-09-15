package pro.tremblay.alljava.conf;

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
