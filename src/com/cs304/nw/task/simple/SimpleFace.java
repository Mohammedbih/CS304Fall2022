package com.cs304.nw.task.simple;

import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class SimpleFace extends JFrame {
    GLCanvas glcanvas;
    SimpleFaceGLListener listener = new SimpleFaceGLListener();
    static FPSAnimator animator;

    public SimpleFace() {
        super("Simple Face");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        animator = new FPSAnimator(glcanvas,90);

        add(glcanvas, BorderLayout.CENTER);
        setSize(1000, 1000);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleFace();
        animator.start();
    }
}
