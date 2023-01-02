/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.examples;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Henri Tremblay
 */
public class NewDate {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    String thatSpecialDay = now
      .withDayOfMonth(1)
      .atZone(ZoneId.of("Europe/Paris"))
      .plus(Duration.ofDays(5))
      .format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

    System.out.println(thatSpecialDay); // 2014-11-06T16:22:22.488+01:00[Europe/Paris]
  }
}
