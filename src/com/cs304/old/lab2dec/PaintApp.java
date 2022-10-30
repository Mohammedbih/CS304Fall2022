/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs304.old.lab2dec;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Saiko-Store
 */
public class PaintApp extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

  private GLCanvas glcanvas;
  private PaintGLEventListener listener = new PaintGLEventListener();
  private final JPanel jPanel;
  private final JButton color;
  private final JButton clear;
  private final JButton undo;
  private final JButton redo;
  private float colorRed = 1.f;
  private float colorBlue = 0.0f;
  private float colorGreen = 0.0f;

  public static void main(String[] args) {
    new PaintApp();
  }

  public PaintApp() {
    super("Paint Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    jPanel = new JPanel();

    color = new JButton("color");
    clear = new JButton("clear");
    undo = new JButton("undo");
    redo = new JButton("redo");

    jPanel.add(color);
    jPanel.add(clear);
    jPanel.add(undo);
    jPanel.add(redo);

    color.addActionListener(this);
    clear.addActionListener(this);
    undo.addActionListener(this);
    redo.addActionListener(this);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    glcanvas.addMouseListener(this);
    glcanvas.addMouseMotionListener(this);

    add(glcanvas, BorderLayout.CENTER);
    add(jPanel, BorderLayout.SOUTH);
    setSize(700, 700);
    setLocationRelativeTo(this);
    setVisible(true);
    glcanvas.requestFocus();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(color)) {
      System.out.println("color");
    } else if (e.getSource().equals(clear)) {
      System.out.println("clear");
    } else if (e.getSource().equals(undo)) {
      System.out.println("undo");
      listener.undo();
      glcanvas.repaint();
    } else if (e.getSource().equals(redo)) {
      System.out.println("redo");
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse Pressed x = " + e.getX() + " y = " + e.getY());
    listener.addStartPoint(e.getX(), e.getY(), colorRed, colorBlue, colorGreen);
    glcanvas.repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse Released x = " + e.getX() + " y = " + e.getY());
    listener.addEndPoint(e.getX(), e.getY(), colorRed, colorBlue, colorGreen);
    glcanvas.repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    System.out.println("Mouse Dragged x = " + e.getX() + " y = " + e.getY());
    listener.addRegularPoint(e.getX(), e.getY(), colorRed, colorBlue, colorGreen);
    glcanvas.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

}
