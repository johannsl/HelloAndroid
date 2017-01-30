package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.graphics.Typeface;

import sheep.game.Sprite;
import sheep.graphics.Font;
import sheep.graphics.Image;

/**
 * Created by johan on 30/01/17.
 */

public class Paddle extends Sprite {

    private final float VELOCITY;
    private static Font font;
    private boolean movingUp;
    private boolean movingDown;
    private int points;

    public Paddle(Image image) {
        super(image);
        VELOCITY = 100;
        font = new Font(255, 255, 255, (MyGame.width * 0.1f), Typeface.SANS_SERIF, Typeface.NORMAL);
        movingUp = false;
        movingDown = false;
        points = 0;
        setPosition(MyGame.width * 0.005f, MyGame.height * 0.5f);
        setShape(100, 400);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(points + "", (MyGame.width * 0.005f), (MyGame.height * 0.005f), font);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        checkWallCollision();
        movePaddle(dt);
    }

    private void checkWallCollision() {
        if (getY() >= MyGame.height && movingDown == true) {
            movingDown = false;
        }
        else if (getY() <= 0 && movingUp) {
            movingUp = false;
        }
    }

    private void movePaddle(float dt) {
        float dy = 0f;
        if (movingUp) {
            dy = dt * -VELOCITY;
        }
        else if (movingDown) {
            dy = dt * VELOCITY;
        }
        setPosition(getX(), getY() + dy);
    }

    public void setMovingUp() {
        movingUp = true;
        movingDown = false;
    }

    public void setMovingDown() {
        movingDown = true;
        movingUp = false;
    }

    public void setStopMoving() {
        movingUp = false;
        movingDown = false;
    }

}
