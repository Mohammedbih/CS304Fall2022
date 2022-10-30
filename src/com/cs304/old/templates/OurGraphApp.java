package com.cs304.old.templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class OurGraphApp extends JFrame {

  private GLCanvas glcanvas;
  private OurGraphGLEventListener listener = new OurGraphGLEventListener();

  public static void main(String[] args) {
    new OurGraphApp();
  }

  public OurGraphApp() {

    super("Our Graph Application");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);

    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
