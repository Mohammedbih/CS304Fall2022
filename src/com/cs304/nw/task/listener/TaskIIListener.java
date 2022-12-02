package com.cs304.nw.task.listener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TaskIIListener implements GLEventListener, MouseListener {
    GLCanvas glc;
    private final ArrayList<MyPoint> points = new ArrayList<>();

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(0, 100, 0, 100, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

//        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        double x, y;
        for (int i = 0; i < points.size(); i++) {
            x = points.get(i).getX();
            y = points.get(i).getY();
            drawPoint(gl, new Color(255, 35, 7), x, y);
            if (i % 2 != 0) {
                drawLine(gl, new Color(120, 232, 255),
                        x, y, points.get(i - 1).getX(), points.get(i - 1).getY());
            }
        }
    }

    private void drawPoint(GL gl, Color color, double x, double y) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glPointSize(3);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glEnd();
    }

    private void drawLine(GL gl, Color color, double x1, double y1, double x2, double y2) {
        gl.glColor3fv(color.getColorComponents(null), 0);
        gl.glLineWidth(5);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();

        Component c = e.getComponent();

        double w = c.getWidth();
        double h = c.getHeight();

        double xPos = (int) ((x / w) * 100);
        double yPos = (int) ((y / h) * 100);

        yPos = 100 - yPos;

        points.add(new MyPoint(xPos, yPos));
        glc.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

class MyPoint {
    private final double x;
    private final double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
