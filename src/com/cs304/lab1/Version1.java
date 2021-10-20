package com.cs304.lab1;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Version1 {

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setTitle("CS304");
    jFrame.setSize(300, 300);
    jFrame.setLocationRelativeTo(jFrame);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
}
