/*
 * Copyright 2018-2023 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Switch02 {

  String translate(String word) {
    if("hello".equals(word)) {
      return "bonjour";
    }
    else if("world".equals(word)) {
      return "monde";
    }
    else {
      return null;
    }
//    switch(word) {
//      case "hello":
//        return "bonjour";
//      case "world":
//        return "monde";
//      default:
//        return null;
//    }

//    int hash = word.hashCode();
//    switch (hash) {
//      case 99162322: { // hashcode of "hello"
//        if (word.equals("hello")) {
//          return "bonjour";
//        }
//        return null;
//      }
//      case 113318802: { // hashcode of "world"
//        if (word.equals("world")) {
//          return "monde";
//        }
//        return null;
//      }
//      default:
//        return null;
//    }
  }

  @Test
  void translateWhatWeKnow() {
    assertThat(translate("hello")).isEqualTo("bonjour");
    assertThat(translate("world")).isEqualTo("monde");
  }

  @Test
  void nullOnWhatWeDontKnow() {
    assertThat(translate("unknown")).isNull();
  }

  @Test
  void nullOnNull() {
    assertThat(translate(null)).isNull();
  }

}

// Uncomment the switch
// Show the bytecode
// Show the actual code that is implemented
// Show that null isn't handled the same way
