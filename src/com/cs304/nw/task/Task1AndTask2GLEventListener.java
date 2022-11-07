package com.cs304.nw.task;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;

import static java.lang.Math.*;

public class Task1AndTask2GLEventListener implements GLEventListener {
    private int angel; private int stepAngel = 2;
    private int yPos; private boolean flg; private int stepPos = 6;
    private float factor = 1; private boolean flgFactor;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-550, 550, -450, 450, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


//        drawRegularRibs(gl,
//                100,
//                new Color(111, 28, 178),
//                8,
//                -550+110);


        gl.glPushMatrix();
        gl.glScalef(factor,factor,1);
        if (factor > 1.5 || factor < .75){
            flgFactor = !flgFactor;
        }
        if (flgFactor){
            factor /= 1.01;
        } else {
            factor *= 1.01;
        }


        drawRegularRibs(gl,
                100,
                new Color(120, 232, 255),
                5,
                -366+90);
        gl.glPopMatrix();

        gl.glPushMatrix();
        if(yPos+ stepPos > 350 || yPos- stepPos < -350) flg=!flg;
        if(flg) yPos-= stepPos; else yPos+= stepPos;
        gl.glTranslated(0, yPos % 350,0);
        drawRegularRibs(gl,
                100,
                new Color(229, 43, 189),
                360,
                0);
        drawStar(gl,
                100,
                new Color(183, 212, 225),
                0);
        gl.glPopMatrix();


//        gl.glPushMatrix();
        angel+=stepAngel;
//        gl.glRotated(angel, 0,0,1);
//        gl.glTranslated(0,0,0);
        drawFreeStar(gl,
                100,
                40,
                new Color(255, 35, 7),
                366-90,
                0,
                angel);

//        gl.glPopMatrix();


    }

    void drawFreeStar(GL gl, int r, int r2, Color c, int x, int y,int rotateFactor) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);

        for (int i = 0; i < 360; i += 60) {
            double f = cos(toRadians(i + rotateFactor));
            double s = sin(toRadians(i + rotateFactor));
            gl.glVertex2d(r2 * f + x,
                    r2 * s + y);
            gl.glVertex2d(r * f + x,
                    r * s + y);
        }

        gl.glEnd();
    }

    private void drawStar(GL gl, int r, Color color, int x) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        final int ROTATE_FACTOR = abs(72 - 90);

        for (int i = 0; i < 360 * 2; i += 72 * 2) // 0 *72 144 *216 288 *360
            gl.glVertex2d(x + r * cos(toRadians(i + ROTATE_FACTOR)),
                    r * sin(toRadians(i + ROTATE_FACTOR)));

        gl.glEnd();
    }

    private void drawRegularRibs(
            GL gl,
            int r,
            Color color,
            int ribs,
            int x) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        int step = 360 / ribs;
        final int ROTATE_FACTOR = abs(step - 90);
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x + r * cos(toRadians(i + ROTATE_FACTOR)),
                    r * sin(toRadians(i + ROTATE_FACTOR)));

        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }
}
