/*
 * Copyright 2018-2020 Henri Tremblay.
 */
package app;

import javax.swing.JFrame;

public class MyApp {
  public static void main(String... args) {
    JFrame frame = new JFrame("Hello!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(640, 480);
    frame.setVisible(true);

  }
}
