/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.random.RandomGenerator;

class RandomGenerator28 {

  @Test
  void test() {
    RandomGenerator generator = new Random();
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));
  }

  @Test
  void test1() {
    RandomGenerator generator = RandomGenerator.getDefault();
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));
  }

  @Test
  void test2() {
    RandomGenerator generator = RandomGenerator.of("L128X1024MixRandom");
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));
  }

  @Test
  void test3() {
    var generator = RandomGenerator.SplittableGenerator.of("L128X1024MixRandom");
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));

    generator = generator.split();
    System.out.println(generator.getClass());
    System.out.println(generator.nextInt(10));
  }
}
