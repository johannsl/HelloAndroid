package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.Display;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.Touch;

/**
 * Created by johan on 27/01/17.
 */

public class Heli extends Sprite {
    
    private final int VELOCITY = 100;
    private boolean moveRight;
    private boolean moveLeft;
    private boolean moveUp;
    private boolean moveDown;
    public static int height;
    public static int width;

    public Heli(Image image) {
        super(image);
        setPosition(200, 200);
        moveRight = false;
        moveLeft = false;
        moveUp = false;
        moveDown = true;
        height = MyGame.height;
        width = MyGame.width;
        System.out.println("####################### " + height + " ### " + width);
    }

    public void update(float dt) {
        super.update(dt);
        if (moveRight) {
            setScale(-1, 1);
            float x = getX();
            float y = getY();
            if (!(x >= width)) {
                float dx = dt * VELOCITY;
                setPosition(x + dx, y);
            }
            else {
                moveRight = false;
                moveLeft = true;
            }
        }
        if (moveLeft) {
            setScale(1, 1);
            float x = getX();
            float y = getY();
            if (!(x <= 0)) {
                float dx = dt * VELOCITY;
                setPosition(x - dx, y);
            }
            else {
                moveLeft = false;
                moveRight = true;
            }
        }
        if (moveUp) {
            float x = getX();
            float y = getY();
            if (!(y <= 0)) {
                float dy = dt * VELOCITY;
                setPosition(x, y - dy);
            }
            else {
                moveUp = false;
                moveDown = true;
            }
        }
        if (moveDown) {
            float x = getX();
            float y = getY();
            if (!(y >= height)) {
                float dy = dt * VELOCITY;
                setPosition(x, y + dy);
            }
            else {
                moveDown = false;
                moveUp = true;
            }
        }
    }

    public void setMoveRight() {
        moveRight = true;
        moveLeft = false;
    }
    public void setMoveLeft() {
        moveLeft = true;
        moveRight = false;
    }
    public void setMoveUp() {
        moveUp = true;
        moveDown = false;
    }
    public void setMoveDown() {
        moveDown = true;
        moveUp = false;
    }
}
