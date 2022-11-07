package com.cs304.nw.task;


import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;

public class Hexa implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-250, 250, -150, 150, -1.0, 1.0);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        int r = 60;

        drawHexane(gl, r, new Color(0f, 1f, 0f, 1f));
        drawOctane(gl, r, new Color(0f, 0f, 1f, 1f));
        drawCircle(gl, r, new Color(1f, 0f, 0f, 1f));
    }

    public void drawHexane(GL gl, int r, Color c) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int stp = 360 / 6;
        for (int i = 0; i < 360; i += stp)
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        gl.glEnd();
    }

    public void drawOctane(GL gl, int r, Color c) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int stp = 360 / 8;
        for (int i = 0; i < 360; i += stp)
            gl.glVertex2d(2*r + r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        gl.glEnd();
    }

    public void drawCircle(GL gl, int r, Color c) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i += 10)
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)) - 2*r, r * Math.sin(Math.toRadians(i)));
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }


}