/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordPatternMatching33 {

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

  @Test
  public void test() {
    assertThat(circonference(new Circle(2))).isEqualTo(4 * Math.PI);
  }

  double circonference(Shape s) {
    if (s instanceof Circle c) {
      return 2 * Math.PI * c.radius();
    }
    return 0;
  }

  record Pair<T, U>(T s1, U s2) {}

  @Test
  public void nesting() {
    Pair<Shape, Shape> pair = new Pair<>(new Circle(2), new Square(2));
    if (pair instanceof Pair<Shape, Shape> p) {
//      System.out.println(p.radius());
//      System.out.println(s.side());
    }
  }

  // change instanceof to use pattern matching
  // var
  // switch above
  // we can nest
}
