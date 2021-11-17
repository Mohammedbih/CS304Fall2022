package com.cs304.templates.simple;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class SimpleGLEventListener implements GLEventListener {

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    gl.glOrtho(0.0, 500.0, 0.0, 300.0, -1.0, 1.0);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    gl.glPointSize(13.0f);

    gl.glColor3f(1.0f, 0.0f, 0.0f);

    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(300, 150);
    gl.glEnd();

    gl.glPointSize(33.0f);

    gl.glColor3f(0.0f, 1.0f, 0.0f);

    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(200, 150);
    gl.glEnd();

    gl.glPointSize(53.0f);

    gl.glColor3f(0.0f, 0.0f, 1.0f);

    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(400, 150);
    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }
}
