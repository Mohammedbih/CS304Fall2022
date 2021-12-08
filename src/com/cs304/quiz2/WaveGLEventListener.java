package com.cs304.quiz2;

import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class WaveGLEventListener implements GLEventListener {

  private static final int X_MIN = 0;
  private static final int X_MAX = 700;
  private static final int Y_MIN = 0;
  private static final int Y_MAX = 500;
  private static final double ONE_DEGREE = (Math.PI / 180);
  private static final double THREE_SIXTY = 2 * Math.PI;
  private static final double RADIUS = 5;
  private List<PointColor> pointColorList = new ArrayList<>();
  private int idx = 0;

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    gl.glOrtho(X_MIN, X_MAX, Y_MIN, Y_MAX, -1.0, 1.0);

    float red = (float) Math.random();
    float green = (float) Math.random();
    float blue = (float) Math.random();

    for (int x = X_MIN; x < X_MAX; x += 10) {

      pointColorList.add(new PointColor(red, green, blue));

      if (x % 70 == 0) {
        red = (float) Math.random();
        green = (float) Math.random();
        blue = (float) Math.random();
      }

    }
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {

    idx++;

    idx %= pointColorList.size();

    GL gl = glAutoDrawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    gl.glBegin(GL.GL_POINTS);

    for (int x = X_MAX; x >= X_MIN; x -= 10) {

      drawPointAndCircle(gl, x, (Y_MAX - Y_MIN) / 2 + (Math.sin(x / 60.0) * 100.0),
          pointColorList.get(idx++));

      idx %= pointColorList.size();
    }

    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  private void drawPointAndCircle(GL gl, double x, double y, PointColor pointColor) {

    gl.glBegin(GL.GL_POINTS);

    gl.glColor3f(pointColor.red, pointColor.green, pointColor.blue);

    drawPoint(gl, x, y);

    drawCircle(gl, x, y);

    gl.glEnd();
  }

  private void drawPoint(GL gl, double x, double y) {
    gl.glVertex2d(x, y);
  }

  private void drawCircle(GL gl, double x, double y) {
    for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
      double xx = x + RADIUS * (Math.cos(a));
      double yy = y + RADIUS * (Math.sin(a));
      gl.glVertex2d(xx, yy);
    }
  }
}
