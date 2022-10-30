package com.cs304.old.templates;

import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class FirstCircle extends JFrame {

  private GLCanvas glcanvas;
  private FirstCircleEventListener listener = new FirstCircleEventListener();

  public static void main(String[] args) {
    new FirstCircle();
  }

  public FirstCircle() {
//set the JFrame title
    super("First Circle Using Sine and Cosine");
    //kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
//add the GLCanvas just like we would any Component
    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}
