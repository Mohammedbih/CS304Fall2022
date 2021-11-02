package com.cs304.lab3;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class SimpleJoglApp extends JFrame {

  public static void main(String[] args) {
    new SimpleJoglApp();
  }

  public SimpleJoglApp() {
    super("Simple JOGL Application");

    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(new SimpleGLEventListener());
    add(glcanvas, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
