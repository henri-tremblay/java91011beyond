/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;
import pro.tremblay.alljava.UserDao;

import java.util.List;

class OptionalTest11 {

  List<String> list = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  void findHenriAndPrintIt() {
    int i = list.indexOf("Henri");
    if(i >= 0) {
      String henri = list.get(i);
      System.out.println(henri);
    }
  }

  @Test
  void orElse() {
    UserDao dao = new UserDao();
    User user = dao.find("Henri");
    if(user == null) {
      System.out.println("404");
    }
    else {
      System.out.println(user.getName());
    }
  }

}
