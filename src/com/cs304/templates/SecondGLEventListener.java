package com.cs304.templates;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class SecondGLEventListener implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrtho(0.0, 500.0, 0.0, 300.0, -1, 1);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    float red = 0.0f;
    float green = 0.0f;
    float blue = 0.0f;
    GL gl = glAutoDrawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glPointSize(5.0f);
    for (int i = 0; i < 50; i++) {
      red -= .09f;
      green -= .12f;
      blue -= .15f;
      if (red < 0.15) {
        red = 1.0f;
      }
      if (green < 0.15) {
        green = 1.0f;
      }
      if (blue < 0.15) {
        blue = 1.0f;
      }
      gl.glColor3f(red, green, blue);
      gl.glBegin(GL.GL_POINTS);
      gl.glVertex2i((i * 10), 150);
      gl.glEnd();
    }
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }
}
