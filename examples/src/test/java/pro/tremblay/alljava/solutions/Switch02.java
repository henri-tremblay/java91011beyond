/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Switch02 {

  // show the bytecode for a switch
  // show the null isn't handled the same way

  String translate0(String word) {
    if("hello".equals(word)) {
      return "bonjour";
    }
    else if("world".equals(word)) {
      return "monde";
    }
    return null;
  }

  String translate1(String word) {
    switch(word) {
      case "hello":
        return "bonjour";
      case "world":
        return "monde";
    }
    return null;
  }

  String translate(String word) {
    if(word == null) {
      return null;
    }
    switch(word) {
      case "hello":
        return "bonjour";
      case "world":
        return "monde";
    }
    return null;
  }

  @Test
  public void translateWhatWeKnow() {
    assertThat(translate("hello")).isEqualTo("bonjour");
    assertThat(translate("world")).isEqualTo("monde");
  }

  @Test
  public void nullOnWhatWeDontKnow() {
    assertThat(translate("unknown")).isNull();
  }
}
