/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

sealed interface Shape permits Circle, Polygon {
  default double area() {
    if (this instanceof Circle c) return Math.PI * c.radius() * c.radius();
    if (this instanceof Square s) return s.side() * s.side();
    if (this instanceof Rectangle r) return r.width() * r.height();
    if (this instanceof Polygon) throw new UnsupportedOperationException("Polygons should override area()");
    throw new UnsupportedOperationException("Unknown shape: " + getClass());
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
