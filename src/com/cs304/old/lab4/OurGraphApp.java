package com.cs304.old.lab4;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class OurGraphApp extends JFrame {

  public static void main(String[] args) {
    new OurGraphApp();
  }

  public OurGraphApp() {
    super("The Cartesian Coordinate System");

    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(new OurGraphGLEventListener());
    add(glcanvas, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
