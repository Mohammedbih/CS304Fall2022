package com.cs304.lab6;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class Square2App extends JFrame {

  private GLCanvas glcanvas;
  private Square2GLEventListener listener = new Square2GLEventListener();

  public static void main(String[] args) {
    new Square2App();
  }

  public Square2App() {
    super("Square2 Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
