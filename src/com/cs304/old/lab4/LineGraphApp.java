package com.cs304.old.lab4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineGraphApp extends JFrame implements ActionListener {

  LineGLEventListener listener = new LineGLEventListener();
  GLCanvas glcanvas;
  JTextField ajtf = new JTextField("3", 3);
  JTextField bjtf = new JTextField("2", 3);
  JTextField mjtf = new JTextField("-1", 6);

  public static void main(String[] args) {
    new LineGraphApp();
  }

  public LineGraphApp() {
//set the JFrame title
    super("Point-Slope Calculation");
//kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setting up our southern JPanel
    JPanel jp = new JPanel();
//adding the JTextFields and JLabels
    jp.add(new JLabel("x:"));
    jp.add(ajtf);
    jp.add(new JLabel(" y:"));
    jp.add(bjtf);
    jp.add(new JLabel(" slope: "));
    jp.add(mjtf);//adding the JButton
    JButton jb = new JButton("Redraw");
    jb.addActionListener(this);
    jp.add(jb);
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

  @Override
  public void actionPerformed(ActionEvent e) {
    listener.a = Double.parseDouble( ajtf.getText() );
    listener.b = Double.parseDouble( bjtf.getText() );
    listener.m = Double.parseDouble( mjtf.getText() );
    glcanvas.repaint();
  }
}
