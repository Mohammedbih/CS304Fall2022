package com.cs304.nw.task.listener;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class TaskII extends JFrame {
    GLCanvas glcanvas;
    TaskIIListener listener = new TaskIIListener();

    public TaskII() {
        super("Task 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addMouseListener(listener);
        listener.glc = glcanvas;

        add(glcanvas, BorderLayout.CENTER);
        setSize(400, 400);
        setLocationRelativeTo(this);
//        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TaskII();
    }
}
