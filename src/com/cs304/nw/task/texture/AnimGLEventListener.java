package com.cs304.nw.task.texture;


import com.cs304.old.lab9.AnimListener;
import com.cs304.old.lab9.Texture.TextureReader;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import javax.media.opengl.glu.GLU;

import static java.awt.event.KeyEvent.*;
import static java.lang.Math.*;


enum Dir {
    UP,
    DOWN,
    RIGHT,
    LEFT,
    UP_RIGHT,
    UP_LEFT,
    DOWN_RIGHT,
    DOWN_LEFT
}

public class AnimGLEventListener extends AnimListener implements Constants {

    Dir dir = Dir.UP;
    int angel = ANG_UP;

    HashMap<Point, Dir> map = new HashMap<>();
    ArrayList<Point> helper = new ArrayList<>();



    int animationIndex;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth / 2, y = maxHeight / 2;

    // Download enemy textures from https://craftpix.net/freebies/free-monster-2d-game-items/
    String[] textureNames = {"Man1.png", "Man2.png", "Man3.png", "Man4.png", "Back.png", "Balloon1.png"};
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    int[] textures = new int[textureNames.length];

    /*
     5 means gun in array pos
     x and y coordinate for gun
     */
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        DrawBackground(gl);
        handleKeyPress();
        animationIndex %= 4;

        DrawSprite(gl, x, y, animationIndex, 1);

        map.forEach((point, dir1) -> {
            switch (dir1) {
                case UP -> {
                    DrawSprite(gl, point.x, point.y += 3, 5, 0.25f);
                }
                case DOWN -> {
                    DrawSprite(gl, point.x, point.y -= 3, 5, 0.25f);

                }
                case RIGHT -> {
                    DrawSprite(gl, point.x += 3, point.y, 5, 0.25f);

                }
                case LEFT -> {
                    DrawSprite(gl, point.x -= 3, point.y, 5, 0.25f);

                }
                case UP_RIGHT -> {
                    DrawSprite(gl, point.x += 3, point.y += 3, 5, 0.25f);

                }
                case UP_LEFT -> {
                    DrawSprite(gl, point.x -= 3, point.y += 3, 5, 0.25f);

                }
                case DOWN_RIGHT -> {
                    DrawSprite(gl, point.x += 3, point.y -= 3, 5, 0.25f);

                }
                case DOWN_LEFT -> {
                    DrawSprite(gl, point.x -= 3, point.y -= 3, 5, 0.25f);

                }
            }
            if (abs(point.x) > 100 || abs(point.y) > 100) {
                //Remove from map
               helper.add(point);
            }
        });

        for (int i = 0; i < helper.size(); i++) {
            System.out.println(map.remove(helper.get(0)));
        }
        System.out.println(map.size());
    }


    /**
     * keyListener
     */
    public void handleKeyPress() {

        if (isKeyPressed(VK_LEFT))
        {
            if (x > 0) x--;
        }


        if (isKeyPressed(VK_RIGHT))
        {
            if (x < maxWidth - 10) x++;
        }

        if (isKeyPressed(VK_DOWN))
        {
            if (y > 0) y--;
        }

        if (isKeyPressed(VK_UP))
        {
            if (y < maxHeight - 10) y++;
        }

        //Directions
        if (isKeyPressed(VK_RIGHT) && isKeyPressed(VK_UP)) {
            angel = ANG_UP_RIGHT;
            dir = Dir.UP_RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT) && isKeyPressed(VK_UP)) {
            angel = ANG_UP_LEFT;
            dir = Dir.UP_LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT) && isKeyPressed(VK_DOWN)) {
            angel = ANG_DOWN_LEFT;
            dir = Dir.DOWN_LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_RIGHT) && isKeyPressed(VK_DOWN)) {
            angel = ANG_DOWN_RIGHT;
            dir = Dir.DOWN_RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_UP)) {
            angel = ANG_UP;
            dir = Dir.UP;
            animationIndex++;
        } else if (isKeyPressed(VK_RIGHT)) {
            angel = ANG_RIGHT;
            dir = Dir.RIGHT;
            animationIndex++;
        } else if (isKeyPressed(VK_LEFT)) {
            angel = ANG_LEFT;
            dir = Dir.LEFT;
            animationIndex++;
        } else if (isKeyPressed(VK_DOWN)) {
            angel = ANG_DOWN;
            dir = Dir.DOWN;
            animationIndex++;
        }

        //Fire
        if (isKeyPressed(VK_SPACE)) {
            map.put(new Point(x, y), dir);
        }


    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, int x, int y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);    // Turn Blending On


        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
        gl.glRotatef(angel, 0, 0, 1); //Dir
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);

        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[4]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }


    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
}

interface Constants {

    int ANG_UP_RIGHT = 315;
    int ANG_UP_LEFT = 45;
    int ANG_DOWN_LEFT = 135;
    int ANG_DOWN_RIGHT = 225;
    int ANG_UP = 0;
    int ANG_DOWN = 180;
    int ANG_LEFT = 90;
    int ANG_RIGHT = 270;

}
