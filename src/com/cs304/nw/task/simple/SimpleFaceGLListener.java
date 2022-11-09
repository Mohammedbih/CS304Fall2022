package com.cs304.nw.task.simple;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;

import static java.lang.Math.*;

public class SimpleFaceGLListener implements GLEventListener {
    private int angelA;
    private int angelB;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-500, 500, -500, 500, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


        drawCircle(gl, 400, new Color(255, 255, 2), 0, 0);

        int xx=230,yy=200;
        {
            gl.glPushMatrix();
            gl.glTranslated(xx,yy,0);
            gl.glRotated(angelA++,0,0,1);
            gl.glTranslated(-xx,-yy,0);
            drawFreeStar(gl, 250, Color.red, xx, yy, 10);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslated(-xx,yy,0);
            gl.glRotated(angelB--,0,0,1);
            gl.glTranslated(xx,-yy,0);
            drawFreeStar(gl, 250, Color.red, -xx, yy, 10);
            gl.glPopMatrix();
        }


        gl.glPushMatrix();
        gl.glRotated(180, 1, 0, 0);
        drawHalfCircle(gl, 250, new Color(2, 2, 1), 0, 110);
        gl.glPopMatrix();

    }

    void drawFreeStar(GL gl, int r, Color c, int x, int y, int ang) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        boolean flgHelper = false;

        for (int i = 0; i < 360; i += 36) {
            double f = cos(toRadians(i + ang));
            double s = sin(toRadians(i + ang));
            if (flgHelper) gl.glVertex2d(r * f + x, r * s + y);
            else gl.glVertex2d((r / 2.0) * f + x, (r / 2.0) * s + y);

            flgHelper = !flgHelper;
        }

        gl.glEnd();
    }

    private void drawHalfCircle(GL gl, int r, Color color, int x, int y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double xDash = x + r * cos(toRadians(i));
            double yDash = y + r * sin(toRadians(i));
            gl.glVertex2d(xDash, yDash);

            if (xDash == x - r) break;
        }

        gl.glEnd();
    }

    private void drawCircle(GL gl, int r, Color color, int x, int y) {
        drawRegularRibs(gl, r, color, 360, x, y);
    }

    private void drawRegularRibs(GL gl, int r, Color color, int ribs, int x, int y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int step = 360 / ribs;
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x + r * cos(toRadians(i)),
                    y + r * sin(toRadians(i)));

        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
