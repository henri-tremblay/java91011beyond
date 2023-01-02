/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomGenerator28 {

  @Test
  public void test() {
    RandomGenerator generator = new Random();
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));
  }

}

// Random is now a RandomGenerator
// synchronized
// RandomGenerator.getDefault();
// generator = RandomGenerator.of("L128X1024MixRandom"); uses service loader
// not synchronized
// not thread-safe
// LeapableGenerator leaps and JumpableGenerator jumps
//

