package com.cs304.nw.task;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class Task1AndTask2 extends JFrame {
    GLCanvas glcanvas;
    Task1AndTask2GLEventListener listener = new Task1AndTask2GLEventListener();
    static FPSAnimator animator;

    public Task1AndTask2() {
        super("Task 1&2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        animator = new FPSAnimator(glcanvas,60);

        add(glcanvas, BorderLayout.CENTER);
        setSize(1000, 800);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task1AndTask2();
        animator.start();
    }
}
