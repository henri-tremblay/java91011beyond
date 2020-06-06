/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;
import pro.tremblay.alljava.User;

public class HelpfulNPETest17 {

  private User user = User.user(null, 14);

  @Test
  public void test() {
      int value = foo();
  }

  private int foo() {
    return user.getAge() + user.getName().length();
  }

}

// Run
// Run with -XX:+ShowCodeDetailsInExceptionMessages
