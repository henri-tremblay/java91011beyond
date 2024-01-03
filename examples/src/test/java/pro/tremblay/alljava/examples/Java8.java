/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Henri Tremblay
 */
public class Java8 {

  @Test
  public void test() {
    Passenger passenger = new Passenger();

    List<Train> trains = Collections.singletonList(new Train());
    trains.forEach(t -> t.repair());
  }

  public static class Passenger {
    public void inboard(Train train) {
      System.out.println("Inboard " + train);
    }
  }

  public static class Train {

    private static int idGenerator = 0;
    private int id = idGenerator++;

    public Train() {
    }

    public Train(int initial) {
      id = initial;
    }

    public static Train create(Supplier<Train> supplier) {
      return supplier.get();
    }

    public static Train create(Function<Integer, Train> supplier, int value) {
      return supplier.apply(value);
    }

    public static void paintBlue(Train train) {
      System.out.println("Painter blue " + train);
    }

    public void repair() {
      System.out.println("Repaired " + this);
    }

    public boolean isBlue() {
      return true;
    }

    @Override
    public String toString() {
      return "Train " + id;
    }
  }

  public void print(Optional<String> message) {
    OptionalInt i;
    OptionalDouble d;
    OptionalLong l;
  }
}
