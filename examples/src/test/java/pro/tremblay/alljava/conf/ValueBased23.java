/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

public class ValueBased23 {

  public static void main(String[] args) {
    Double d = 20.0;
    synchronized (d) {  // javac warning & HotSpot warning
      System.out.println(d);
    }
    Object o = d;
    synchronized (o) { // HotSpot warning
      System.out.println(o);
    }

    Integer i = new Integer(1);
    Integer j = new Integer(1);

    System.out.println(i == j);

    i = Integer.valueOf(1);
    j = Integer.valueOf(1);

    System.out.println(i == j);

    i = 1;
    j = 1;

    System.out.println(i == j);
  }
}

// Find usage for  @jdk.internal.ValueBased
