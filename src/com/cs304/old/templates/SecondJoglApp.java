package com.cs304.old.templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class SecondJoglApp extends JFrame {

  private GLCanvas glcanvas;
  private SecondGLEventListener listener = new SecondGLEventListener();

  public static void main(String[] args) {
    new SecondJoglApp();
  }

  public SecondJoglApp() {

    super("Second JOGL Application");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
