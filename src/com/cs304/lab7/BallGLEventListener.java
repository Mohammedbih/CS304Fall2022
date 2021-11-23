package com.cs304.lab7;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class BallGLEventListener implements GLEventListener {

  private final double X_MIN = -350.0;
  private final double X_MAX = 350.0;
  private final double Y_MIN = -350.0;
  private final double Y_MAX = 350.0;
  private final int NUMBER_OF_DIRECTIONS = 4;
  private final int MAX_STEPS = 30;
  private final double ONE_DEGREE = (Math.PI / 180);
  private final double THREE_SIXTY = 2 * Math.PI;
  private double ballXPosition;
  private double ballYPosition;
  private double ballRadius;
  // 0=up, 1=down, 2=right, 3=left
  private int direction;
  private int steps;


  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    gl.glOrtho(X_MIN, X_MAX, Y_MIN, Y_MAX, -1.0, 1.0);

    ballXPosition = 0;
    ballYPosition = 0;
    ballRadius = 30;

    direction = (int) (Math.random() * NUMBER_OF_DIRECTIONS);
    steps = 1 + (int) (Math.random() * MAX_STEPS);
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    System.err.println("**********************");
    GL gl = glAutoDrawable.getGL();
    updateDirection();
    updateBallPosition();
    drawBall(gl);
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

  }

  /**
   * Draw a ball in the center position (ballXPosition, ballYPosition) with radius=ballRadius.
   *
   * @param gl the object of class GL
   */
  private void drawBall(GL gl) {
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glColor3f(0.5f, 0.0f, 0.5f);
    gl.glBegin(GL.GL_POLYGON);
    for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
      double x = ballXPosition + ballRadius * (Math.cos(a));
      double y = ballYPosition + ballRadius * (Math.sin(a));
      gl.glVertex2d(x, y);
    }
    gl.glEnd();
  }

  /**
   * Update the direction of the ball if the steps number equals to zero and reset the value of the
   * steps.
   */
  private void updateDirection() {
    steps--;
    if (steps != 0) {
      return;
    }
    steps = 1 + (int) (Math.random() * MAX_STEPS);
    int newDirection = direction;
    while (newDirection == direction) {
      newDirection = (int) (Math.random() * NUMBER_OF_DIRECTIONS);
    }
    direction = newDirection;
  }

  /**
   * Update the position of the ball depending on the direction.
   */
  private void updateBallPosition() {
    if (direction == 1) { // up
      ballYPosition++;
    } else if (direction == 2) { // down
      ballYPosition--;
    } else if (direction == 3) { // right
      ballXPosition++;
    } else { // left
      ballXPosition--;
    }

    if (ballXPosition < X_MIN) {
      ballXPosition = X_MAX;
    }

    if (ballXPosition > X_MAX) {
      ballXPosition = X_MIN;
    }

    if (ballYPosition < Y_MIN) {
      ballYPosition = Y_MAX;
    }

    if (ballYPosition > Y_MAX) {
      ballYPosition = Y_MIN;
    }
  }

}
