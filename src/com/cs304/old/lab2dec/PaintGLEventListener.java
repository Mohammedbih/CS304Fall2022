/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs304.old.lab2dec;

import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 * @author Saiko-Store
 */
public class PaintGLEventListener implements GLEventListener {

  private static final int MAX_X = 700;
  private static final int MIN_X = 0;
  private static final int MAX_Y = 700;
  private static final int MIN_Y = 0;

  private List<Point> points = new ArrayList<>();
  private List<Integer> startPoints = new ArrayList<>();
  private List<Integer> endPoints = new ArrayList<>();
  private List<List<Point>> oldSegments = new ArrayList<>();

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    gl.glOrtho(MIN_X, MAX_X, MIN_Y, MAX_Y, -1.0, 1.0);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    for (Point p : points) {
      drawPoint(p, gl);
    }
    System.out.println("-----------");
    System.out.println(points.size());
    System.out.println("Start Points " + startPoints);
    System.out.println("End Points " + endPoints);

  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  private void drawPoint(Point p, GL gl) {
    gl.glPointSize(4.0f);
    gl.glColor3f(p.colorRed, p.colorBlue, p.colorGreen);
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2d(p.x, p.y);
    gl.glEnd();
  }

  public void addStartPoint(double x, double y, float red, float blue, float green) {
    startPoints.add(points.size());
    addPoint(x, y, red, blue, green);
  }

  public void addRegularPoint(double x, double y, float red, float blue, float green) {
    addPoint(x, y, red, blue, green);
  }

  public void addEndPoint(double x, double y, float red, float blue, float green) {
    endPoints.add(points.size());
    addPoint(x, y, red, blue, green);
  }

  private void addPoint(double x, double y, float red, float blue, float green) {
    System.out.println(x + " ******* " + y);
    points.add(new Point(convertX(x), convertY(y), red, blue, green));
  }

  private double convertX(double x) {
    return x;
  }

  private double convertY(double y) {
    return MAX_Y - y;
  }

  public void undo() {
    int idx = startPoints.size() - 1;
    if (idx == -1) {
      return;
    }
    int st = startPoints.get(idx);
    int ed = endPoints.get(idx);
    List<Point> l = new ArrayList<>();
    for (int i = ed; i >= st; i--) {
      l.add(points.get(i));
      points.remove(i);
    }
    oldSegments.add(l);
    startPoints.remove(idx);
    endPoints.remove(idx);
  }
}
