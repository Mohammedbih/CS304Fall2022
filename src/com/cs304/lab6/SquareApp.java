package com.cs304.lab6;


import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class SquareApp extends JFrame {

    private GLCanvas glcanvas;
    private SquareGLEventListener listener = new SquareGLEventListener();

    public static void main(String[] args) {
        new SquareApp();
    }

    public SquareApp() {
        super("Square Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
