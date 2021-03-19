/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import pro.tremblay.alljava.User;
import pro.tremblay.alljava.UserDao;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OptionalTest11 {

  List<String> list = List.of("Henri", "Matthieu", "Anthony", "Chris");

  @Test
  public void findHenriAndPrintIt() {
    int i = list.indexOf("Henri");
    if(i >= 0) {
      String henri = list.get(i);
      System.out.println(henri);
    }
  }

  @Test
  public void orElse() {
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
