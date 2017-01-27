package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.Display;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 27/01/17.
 */

public class Heli extends Sprite {

    private final int VELOCITY = 300;
    private boolean moveRight;
    private boolean moveLeft;
    private boolean moveUp;
    private boolean moveDown;
    public static int height;
    public static int width;

    public Heli(Image image) {
        super(image);
        setPosition(200, 200);
        moveRight = true;
        moveLeft = false;
        moveUp = false;
        moveDown = false;
        height = MyGame.height;
        width = MyGame.width;
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
            float dy = dt * VELOCITY;
            setPosition(x, y - dy);
        }
        if (moveDown) {
            float x = getX();
            float y = getY();
            float dy = dt * VELOCITY;
            setPosition(x, y + dy);
        }
    }
}
