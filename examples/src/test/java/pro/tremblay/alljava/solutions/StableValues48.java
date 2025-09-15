package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class StableValues48 {

//  private static volatile StableValues48 instance;
//
//  public static StableValues48 getInstance() {
//    if (instance == null) {
//      synchronized (StableValues48.class) {
//        if (instance == null) {
//          instance = new StableValues48();
//        }
//      }
//    }
//    return instance;
//  }

//  private static final StableValue<StableValues48> instance = StableValue.of();
//
//  public static StableValues48 getInstance() {
//    return instance.orElseSet(StableValues48::new);
//  }

  private static final Supplier<StableValues48> instance = StableValue.supplier(StableValues48::new);

  public static StableValues48 getInstance() {
    return instance.get();
  }

  private StableValues48() {}

  @Test
  void test() throws Throwable {
    StableValues48 instance = StableValues48.getInstance();
    assertThat(instance).isNotNull();
  }

}
