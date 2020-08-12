package pro.tremblay.alljava.solutions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

sealed interface Shape permits Circle, Polygon {
  double area();
}

record Circle(double radius) implements Shape {

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }
}

non-sealed interface Polygon extends Shape {
}

record Square(double side) implements Polygon {

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
