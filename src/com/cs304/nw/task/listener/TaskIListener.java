package com.cs304.nw.task.listener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static java.lang.Math.*;

enum Dir {
    IDEAL,
    UP,
    DOWN,
    RIGHT,
    LEFT,
    UP_RIGHT,
    UP_LEFT,
    DOWN_RIGHT,
    DOWN_LEFT
}

public class TaskIListener implements GLEventListener, KeyListener {
    private int x;
    private int y;
    private Dir dir = Dir.IDEAL;
    private int distance;
    private final int R = 200;


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 50, 50);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(-400, 400, -400, 400, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        drawLine(gl, new Color(16, 86, 103), 550, -50, -550, -50);
        drawRegularRibs(gl, 50, new Color(255, 255, 1), 360, x, y);

        ////////logic////////////
        switch (dir) {
            case IDEAL -> {
                x = 0;
                y = 0;
                distance = 0;
            }
            case UP -> {
                if (distance <= R) y++;
                else y--;

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case DOWN -> {
                if (distance <= R) y--;
                else y++;

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case RIGHT -> {
                if (distance <= R) x++;
                else x--;

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case LEFT -> {
                if (distance <= R) x--;
                else x++;

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case UP_RIGHT -> {
                if (distance <= R){
                    x++; y++;
                }
                else{
                    x--; y--;
                }

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case UP_LEFT -> {
                if (distance <= R){
                    x--; y++;
                }
                else{
                    x++; y--;
                }

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }
            case DOWN_RIGHT -> {
                if (distance <= R){
                    x++; y--;
                }
                else{
                    x--; y++;
                }

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;

            }
            case DOWN_LEFT -> {
                if (distance <= R){
                    x--; y--;
                }
                else{
                    x++; y++;
                }

                if (distance == 2 * R) dir = Dir.IDEAL;
                distance++;
            }

        }


    }

    private void drawLine(GL gl, Color color, int x1, int y1, int x2, int y2) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glLineWidth(5);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);
        gl.glEnd();
    }

    private void drawRegularRibs(GL gl, int r, Color color, int ribs, int x, int y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        int step = 360 / ribs;
        final int ROTATE_FACTOR = abs(step - 90);
        for (int i = 0; i < 360; i += step)
            gl.glVertex2d(x + r * cos(toRadians(i + ROTATE_FACTOR)),
                    y + r * sin(toRadians(i + ROTATE_FACTOR)));

        gl.glEnd();
    }

    void drawFreeStar(GL gl, int r, int r2, Color c, int x, int y, int rotateFactor) {
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

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_UP -> dir = Dir.UP;
            case VK_DOWN -> dir = Dir.DOWN;
            case VK_RIGHT -> dir = Dir.RIGHT;
            case VK_LEFT -> dir = Dir.LEFT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
