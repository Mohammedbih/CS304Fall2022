package com.cs304.templates.simple;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class SimpleApp extends JFrame {

  private GLCanvas glcanvas;
  private SimpleGLEventListener listener = new SimpleGLEventListener();

  public static void main(String[] args) {
    new SimpleApp();
  }

  public SimpleApp() {
    super("Simple Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }

}
