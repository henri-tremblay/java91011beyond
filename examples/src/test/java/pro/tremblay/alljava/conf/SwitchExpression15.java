/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

public class SwitchExpression15 {

  @Test
  public void mySwitch() {
    assertThat(isWeekDay(DayOfWeek.MONDAY)).isTrue();
    assertThat(isWeekDay(DayOfWeek.SUNDAY)).isFalse();
  }

  private boolean isWeekDay(DayOfWeek day) {
    boolean weekDay;

    switch(day) {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:
      case FRIDAY:
        weekDay = true;
        break;
      case SATURDAY:
      case SUNDAY:
        weekDay = false;
      default:
        throw new IllegalStateException("A new day was added in my week: " + day);
    }

    return weekDay;
  }

}

// PreviewFeature annotations
// com.sun.tools.javac.code.Source
