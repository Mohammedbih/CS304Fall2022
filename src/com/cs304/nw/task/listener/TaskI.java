package com.cs304.nw.task.listener;

import com.cs304.nw.task.Task1AndTask2GLEventListener;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class TaskI extends JFrame {
    GLCanvas glcanvas;
    TaskIListener listener = new TaskIListener();
    static FPSAnimator animator;

    public TaskI() {
        super("Task 1&2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);

        animator = new FPSAnimator(glcanvas,60);
        add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        setLocationRelativeTo(this);
//        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TaskI();
        animator.start();
    }
}
