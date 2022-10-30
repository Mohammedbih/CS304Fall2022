package com.cs304.old.quiz2;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class WaveApp extends JFrame {

  private Animator animator;
  private GLCanvas glcanvas;
  private WaveGLEventListener listener = new WaveGLEventListener();

  public static void main(String[] args) {
    new WaveApp().animator.start();
  }

  public WaveApp() {
    super("Wave Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    animator = new FPSAnimator(10);
    animator.add(glcanvas);

    add(glcanvas, BorderLayout.CENTER);
    setSize(700, 500);
    setLocationRelativeTo(this);
    setVisible(true);
  }

}
