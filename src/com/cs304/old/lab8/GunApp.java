package com.cs304.old.lab8;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class GunApp extends JFrame implements KeyListener {

  private Animator animator;
  private GLCanvas glcanvas;
  private GunGLEventListener listener = new GunGLEventListener();

  public static void main(String[] args) {
    new GunApp().animator.start();
  }

  public GunApp() {
    super("Gun Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    animator = new FPSAnimator(10);
    animator.add(glcanvas);
    glcanvas.addKeyListener(this);

    add(glcanvas, BorderLayout.CENTER);
    setSize(1700, 900);
    setLocationRelativeTo(this);
    setVisible(true);
    setFocusable(true);
    glcanvas.requestFocus();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      System.out.println("UP");
      listener.updateGunPosition(KeyEvent.VK_UP);
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      System.out.println("DOWN");
      listener.updateGunPosition(KeyEvent.VK_DOWN);
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      System.out.println("RIGHT");
      listener.updateGunPosition(KeyEvent.VK_RIGHT);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      System.out.println("LEFT");
      listener.updateGunPosition(KeyEvent.VK_LEFT);
    } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      System.out.println("SPACE");
      listener.fireBullet();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
