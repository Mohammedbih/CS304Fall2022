package com.cs304.nw.task.simple;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;
import java.util.Random;

import static java.lang.Math.*;

public class SimpleFaceGLListener implements GLEventListener {
    private int angelA;
    private int angelB;

    private double xp, yp;
    private boolean xIncrease = true, yIncrease = true;

    private double theta = 30;
    private Random random = new Random();

    private final static int BOUND = 500;


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(255f, 255f, 255f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-500, 500, -500, 500, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


        int x = 0, y = 0, r = 150;

        gl.glPushMatrix();
        gl.glTranslated(xp, yp, 1);
        drawFace(gl, x, y, r);
        gl.glPopMatrix();

        //logic
        if (isXTouched(xp, r)) xIncrease = !xIncrease;

        if (isYTouched(yp, r)) yIncrease = !yIncrease;

        if (isXTouched(xp, r) || isYTouched(yp, r)) theta = random.nextInt(180);

        double cs = cos(toRadians(theta));
        double si = sin(toRadians(theta));

        if (xIncrease) xp += cs; else xp -= cs;

        if (yIncrease) yp += si; else yp -= si;

    }

    private boolean isXTouched(double x, int r) {
        return (x + r >= BOUND || x - r <= -BOUND);
    }

    private boolean isYTouched(double y, int r) {
        return (y + r >= BOUND || y - r <= -BOUND);
    }


    void drawFace(GL gl, int x, int y, int r) {
        drawCircle(gl, r, new Color(255, 255, 2), x, y);

        int xx = r / 2, yy = r / 2;
        {
            gl.glPushMatrix();
            gl.glTranslated(xx, yy, 0);
            gl.glRotated(angelA++, 0, 0, 1);
            gl.glTranslated(-xx, -yy, 0);
            drawCircle(gl, r / 4, new Color(255, 255, 255), xx, yy);
            drawCircle(gl, r / 9, new Color(0, 0, 0), xx + r / 10, yy);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslated(-xx, yy, 0);
            gl.glRotated(angelB--, 0, 0, 1);
            gl.glTranslated(xx, -yy, 0);
            drawCircle(gl, r / 4, new Color(255, 255, 255), -xx, yy);
            drawCircle(gl, r / 9, new Color(0, 0, 0), -xx - r / 10, yy);
            gl.glPopMatrix();
        }



        drawCircle(gl, r / 3, new Color(2, 2, 1), x, y - (r / 3));
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
