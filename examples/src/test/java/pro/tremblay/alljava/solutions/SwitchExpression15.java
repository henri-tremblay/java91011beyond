/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * - Show the failing switch
 * - Add the missing break
 * - Change to the arrow syntax but still assign to weekDay
 * - Return directly
 * - Show that it needs to be exhaustive
 * - Yield with the old syntax
 *
 * @author Henri Tremblay
 */
// https://openjdk.java.net/jeps/361
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

  private boolean isWeekDay2(DayOfWeek day) {
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
        break;
      default:
        throw new IllegalStateException("A new day was added in my week: " + day);
    }

    return weekDay;
  }

  private boolean isWeekDay3(DayOfWeek day) {
    boolean weekDay;

    switch(day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> weekDay = true;
      case SATURDAY, SUNDAY -> weekDay = false;
      default -> throw new IllegalStateException("A new day was added in my week: " + day);
    }

    return weekDay;
  }

  private boolean isWeekDay4(DayOfWeek day) {
    boolean weekDay = switch(day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
      case SATURDAY, SUNDAY -> false;
      default -> throw new IllegalStateException("A new day was added in my week: " + day);
    };

    return weekDay;
  }

  private boolean isWeekDay5a(DayOfWeek day) {
    return switch(day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
      case SATURDAY, SUNDAY -> false;
      default -> throw new IllegalStateException("A new day was added in my week: " + day);
    };
  }

  private boolean isWeekDay5b(DayOfWeek day) {
    return switch(day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
      case SATURDAY, SUNDAY -> false;
    };
  }

  private boolean isWeekDay6(DayOfWeek day) {
    boolean onEarth = true;
    return switch(day) {
      case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
      case SATURDAY, SUNDAY -> false;
      default -> {
        if(onEarth) {
          yield false;
        }
        yield true;
      }
    };
  }

  private boolean isWeekDay7(DayOfWeek day) {
    return switch(day) {
      case MONDAY:
      case TUESDAY:
      case WEDNESDAY:
      case THURSDAY:
      case FRIDAY:
        yield true;
      case SATURDAY:
      case SUNDAY:
        yield false;
    };
  }
}
