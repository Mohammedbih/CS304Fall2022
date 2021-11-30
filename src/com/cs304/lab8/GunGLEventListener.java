package com.cs304.lab8;

import java.awt.event.KeyEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.swing.JOptionPane;

public class GunGLEventListener implements GLEventListener {

  private static final int MIN_X = 0;
  private static final int MAX_X = 1700;
  private static final int MIN_Y = 0;
  private static final int MAX_Y = 900;

  private static final int DI = 50;
  private static final int DJ = 50;

  private static final int BULLET_MARGIN = 2;
  private static final int GUN_MARGIN = 6;

  private static final int MAX_ENEMIES = 2;

  // 0=empty & 1=gun & 2= enemy
  private int[][] entity = new int[DI][DJ];
  // 0= empty & 1=bullet
  private int[][] bullet = new int[DI][DJ];
  private int gunX;
  private int gunY;

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();

    gl.glOrtho(MIN_X, MAX_X, MIN_Y, MAX_Y, -1.0, 1.0);

    gunX = 2;
    gunY = DJ / 2;
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    GL gl = glAutoDrawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);

    moveEnemies();
    moveBullets();
    generateEnemies();
    resolveCollision();

    drawGun(gl);
    drawEnemies(gl);
    drawBullets(gl);

  }

  private void drawBullets(GL gl) {
    for (int i = 0; i < DI; i++) {
      for (int j = 0; j < DJ; j++) {
        if (bullet[i][j] == 1) {
          drawBullet(gl, i, j);
        }
      }
    }
  }

  private void drawBullet(GL gl, int x, int y) {
    gl.glPointSize(5.0f);
    gl.glColor3f(1.0f, 0.0f, 0.0f);
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(convertX(x), convertY(y));
    gl.glEnd();
  }

  private void drawEnemies(GL gl) {
    for (int i = 0; i < DI; i++) {
      for (int j = 0; j < DJ; j++) {
        if (entity[i][j] == 2) {
          drawEnemy(gl, i, j);
        }
      }
    }
  }

  private void drawEnemy(GL gl, int x, int y) {
    gl.glPointSize(30.0f);
    gl.glColor3f(0.0f, 1.0f, 0.0f);
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(convertX(x), convertY(y));
    gl.glEnd();
  }

  private void drawGun(GL gl) {
    gl.glPointSize(20.0f);
    gl.glColor3f(0.0f, 0.0f, 1.0f);
    gl.glBegin(GL.GL_POINTS);
    gl.glVertex2i(convertX(gunX), convertY(gunY));
    gl.glEnd();
  }

  private void resolveCollision() {
    resolveBulletCollision();
    resolveGunCollision();
  }

  private void resolveBulletCollision() {
    for (int i = 0; i < DI; i++) {
      for (int j = 0; j < DJ; j++) {
        for (int k = Math.max(0, j - BULLET_MARGIN); k < Math.min(DJ, j + BULLET_MARGIN + 1); k++) {
          if (bullet[i][k] == 1 && entity[i][k] == 2) {
            bullet[i][k] = 0;
            entity[i][k] = 0;
            break;
          }
        }
      }
    }
  }

  private void resolveGunCollision() {
    for (int i = 0; i < DI; i++) {
      for (int j = 0; j < DJ; j++) {
        for (int k = Math.max(0, j - GUN_MARGIN); k < Math.min(DJ, j + GUN_MARGIN + 1); k++) {
          if (entity[i][k] == 2 && i == gunX && k == gunY) {
            System.out.println("GameOver");
            JOptionPane.showMessageDialog(null, "GameOver.", "GameOver",
                JOptionPane.WARNING_MESSAGE);
            System.exit(0);
          }
        }
      }
    }
  }

  private void generateEnemies() {
    int cnt = MAX_ENEMIES;
    while (cnt-- > 0) {
      int x = 48;
      int y = (int) (Math.random() * DJ);
      entity[x][y] = 2;
    }
  }

  private void moveBullets() {
    for (int i = DI - 2; i >= 0; i--) {
      for (int j = 0; j < DJ; j++) {
        if (bullet[i][j] == 1) {
          bullet[i][j] = 0;
          bullet[i + 1][j] = 1;
        }
      }
    }

    for (int j = 0; j < DJ; j++) {
      if (bullet[DI - 1][j] == 1) {
        bullet[DI - 1][j] = 0;
      }
    }
  }

  private void moveEnemies() {
    for (int i = 1; i < DI; i++) {
      for (int j = 0; j < DJ; j++) {
        if (entity[i][j] == 2) {
          entity[i][j] = 0;
          entity[i - 1][j] = 2;
        }
      }
    }

    for (int j = 0; j < DJ; j++) {
      if (entity[0][j] == 2) {
        entity[0][j] = 0;
      }
    }
  }

  private int convertX(int x) {
    return x * MAX_X / DI;
  }

  private int convertY(int y) {
    return y * MAX_Y / DJ;
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
  }

  @Override
  public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {
  }

  public void updateGunPosition(int code) {

    entity[gunX][gunY] = 0;

    if (code == KeyEvent.VK_UP) {
      gunY++;
    } else if (code == KeyEvent.VK_DOWN) {
      gunY--;
    } else if (code == KeyEvent.VK_RIGHT) {
      gunX++;
    } else if (code == KeyEvent.VK_LEFT) {
      gunX--;
    }

    if (gunX < 0) {
      gunX++;
    }

    if (gunX == DI) {
      gunX--;
    }

    if (gunY < 0) {
      gunY++;
    }

    if (gunY == DJ) {
      gunY--;
    }

    entity[gunX][gunY] = 1;

  }


  public void fireBullet() {
    if (gunY + 1 != DJ) {
      bullet[gunX][gunY + 1] = 1;
    }
  }
}
