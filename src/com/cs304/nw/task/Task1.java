package com.cs304.nw.task;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Task1 extends JFrame {
    GLCanvas glcanvas;
    Task1GLEventListener listener = new Task1GLEventListener();

    public Task1() {
        super("Simple Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task1();
    }
}
