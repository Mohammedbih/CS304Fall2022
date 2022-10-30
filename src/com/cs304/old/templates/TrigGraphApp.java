package com.cs304.old.templates;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TrigGraphApp extends JFrame implements ActionListener {
  //Notice we've given these two objects a larger scope.
//Local scope to the constructor was no longer sufficient.
  TrigGLEventListener listener = new TrigGLEventListener();
  GLCanvas glcanvas;
  public static void main(String[] args) {
    new TrigGraphApp();
  }
  public TrigGraphApp() {
//set the JFrame title
    super("Sine, Cosine and Tangent");
//kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setting up our southern JPanel with JRadioButtons
    JPanel jp = new JPanel();
    ButtonGroup bg = new ButtonGroup();
//setting up the sine JRadioButton
    JRadioButton jrb1 = new JRadioButton("Sine", true);
    jrb1.setActionCommand("sine");
    jrb1.addActionListener(this);
//setting up the cosine JRadioButton
    JRadioButton jrb2 = new JRadioButton("Cosine");
    jrb2.setActionCommand("cosine");
    jrb2.addActionListener(this);
//setting up the tangent JRadioButton
    JRadioButton jrb3 = new JRadioButton("Tangent");
    jrb3.setActionCommand("tangent");
    jrb3.addActionListener(this);
//adding the buttons to the ButtonGroup
    bg.add( jrb1 );
    bg.add( jrb2 );
    bg.add( jrb3 );
//adding the buttons to the JPanel
    jp.add( jrb1 );
    jp.add( jrb2 );
    jp.add( jrb3 );
    getContentPane().add("South", jp);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
//add the GLCanvas just like we would any Component
    getContentPane().add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);
//center the JFrame on the screen
    setLocationRelativeTo(this);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    listener.whatToDraw = ae.getActionCommand();
    glcanvas.repaint();
  }
}
