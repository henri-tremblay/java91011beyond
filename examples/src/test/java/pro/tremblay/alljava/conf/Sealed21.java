/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class Shape {
  public abstract double area();
}

class Circle extends Shape {

  private final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }
}

abstract class Polygon extends Shape {
}

class Square extends Polygon {

  private final double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double area() {
    return side * side;
  }
}

public class Sealed21 {

  @Test
  public void test() {
    Shape s = new Circle(2);
    assertThat(s.area()).isEqualTo(2 * 2 * Math.PI);
  }
}

// Show sealed, final, permits, non-sealed
// interface Shape
// record
