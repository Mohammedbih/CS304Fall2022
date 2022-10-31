package com.cs304.nw.task;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;

import static java.lang.Math.*;

public class Task1GLEventListener implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-250,250, -150,150, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        drawRegularRibs(gl,
                50,
                new Color(28, 149, 178),
                6,
                150);
        drawRegularRibs(gl,
                60,
                new Color(120, 232, 255),
                8,
                -150);
        drawRegularRibs(gl,
                70,
                new Color(16, 86, 103),
                360,
                0);


    }

    private void drawRegularRibs(
            GL gl,
            int r,
            Color color,
            int ribs,
            int x) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);

        int step = 360 / ribs;
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x+r * cos(toRadians(i)), r * sin(toRadians(i)));

        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
