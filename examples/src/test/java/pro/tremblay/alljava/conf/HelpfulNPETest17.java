/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;

class HelpfulNPETest17 {

  private User user = User.user(null, 14);

  @Test
  void test() {
      int value = foo();
  }

  private int foo() {
    return user.getAge() + user.getName().length();
  }

}

// Run
// Run with -XX:+ShowCodeDetailsInExceptionMessages
