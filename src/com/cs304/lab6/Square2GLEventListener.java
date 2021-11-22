package com.cs304.lab6;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class Square2GLEventListener implements GLEventListener  {

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

    gl.glColor3f(1.0f, 0.0f, 0.0f);

    drawRect(gl,50,0);
    drawRect(gl,100,25);
    drawRect(gl,150,50);
    drawRect(gl,200,75);
  }

  public  void drawRect(GL gl, int x, int y){
    gl.glColor3f(1.0f, 0.0f, 0.0f);
    gl.glBegin(GL.GL_LINE_LOOP);

    gl.glVertex2i(x, y);
    gl.glVertex2i(x+250, y);

    gl.glVertex2i(x+250, y+200);
    gl.glVertex2i(x, y+200);

    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }
}
