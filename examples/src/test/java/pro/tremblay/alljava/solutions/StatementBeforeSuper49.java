/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class Point2D {
  private static final Pattern PATTERN = Pattern.compile("^\\((\\d+),\\s*(\\d+)\\)$");
  private final int x;
  private final int y;

  public Point2D(int x, int y) {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("x and y must be positive");
    }
    this.x = x;
    this.y = y;
  }

  public Point2D(String s) {
    Matcher matcher = PATTERN.matcher(s);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid point: " + s);
    }
    this(
      extract(matcher, 1),
      extract(matcher, 2)
    );
  }

  private static int extract(Matcher matcher, int group) {
    return Integer.parseInt(matcher.group(group));
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }
}

class Point3D extends Point2D {
  private final int z;

  public Point3D(int x, int y, int z) {
    if (z < 0) {
      throw new IllegalArgumentException("z must be positive");
    }
    super(x, y);
    this.z = z;
  }

  public int z() {
    return z;
  }
}

class StatementBeforeSuper49 {

  @Test
  void test() {
    Point2D point = new Point2D("(1,2)");
    assertThat(point.x()).isEqualTo(1);
    assertThat(point.y()).isEqualTo(2);
  }

}
