/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

sealed interface Shape permits Circle, Polygon {
  default double area() {
    return switch (this) {
      case Circle c -> Math.PI * c.radius() * c.radius();
      case Square s -> s.side() * s.side();
      case Rectangle r -> r.width() * r.height();
      case Polygon ignored -> throw new UnsupportedOperationException("Polygons should override area()");
    };
  }
}

record Circle(double radius) implements Shape {}

non-sealed interface Polygon extends Shape {
}

record Square(double side) implements Polygon {
}

class Rectangle implements Polygon {

  private final double width;
  private final double height;

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double width() {
    return width;
  }

  public double height() {
    return height;
  }

  @Override
  public double area() {
    return width * height;
  }
}

class Sealed21 {

  @Test
  void test() {
    Shape s = new Circle(2);
    assertThat(s.area()).isEqualTo(2 * 2 * Math.PI);
  }
}

// Show sealed, final, permits, non-sealed
// interface Shape
// record
