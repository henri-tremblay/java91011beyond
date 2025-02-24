/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class RecordPatternMatching33 {

  sealed interface Shape permits Circle, Polygon {
    default double area() {
      if (this instanceof Circle c) {
        return Math.PI * c.radius() * c.radius();
      }
      if (this instanceof Square s) {
        return s.side() * s.side();
      }
      if (this instanceof Rectangle r) {
        return r.width() * r.height();
      }
      if (this instanceof Polygon) {
        throw new UnsupportedOperationException("Polygons should override area()");
      }
      throw new UnsupportedOperationException("Unknown shape: " + getClass());
    }
  }

  record Circle(double radius) implements Shape {}

  non-sealed interface Polygon extends Shape {
  }

  record Square(double side) implements Polygon {
  }

  static class Rectangle implements Polygon {

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
    assertThat(circumference(new Circle(2))).isEqualTo(4 * Math.PI);
  }

  double circumference(Shape s) {
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
    } else {
      fail("Should be a square");
    }
  }

  // change instanceof to use pattern matching
  // var
  // switch above
  // we can nest
}
