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
    public boolean isBot;

    public Paddle(Image image) {
        super(image);
        VELOCITY = 200f;
        font = new Font(255, 255, 255, (MyGame.width * 0.05f), Typeface.SANS_SERIF, Typeface.NORMAL);
        movingUp = false;
        movingDown = false;
        points = 0;
        isBot = false;
        setPosition(MyGame.width * 0.015f, MyGame.height * 0.5f);
        setScale(0.2f, 0.2f);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (isBot) {
            canvas.drawText(points + "", (MyGame.width * 0.95f), (MyGame.height * 0.15f), font);
            return;
        }
        canvas.drawText(points + "", (MyGame.width * 0.05f), (MyGame.height * 0.15f), font);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        checkWallCollision();
        movePaddle(dt);
    }

    private void checkWallCollision() {
        if (getY() >= MyGame.height * 0.7f && movingDown == true) {
            movingDown = false;
            if (isBot) {
                movingUp = true;
            }
        }
        else if (getY() <= MyGame.height * 0.1f && movingUp) {
            movingUp = false;
            if (isBot) {
                movingDown = true;
            }
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

    @Override
    public boolean collides(Sprite sprite) {
        Ball ball = (Ball) sprite;
        if ((isBot && ball.getX() >= MyGame.width * 0.9) || (ball.getX() <= MyGame.width * 0.1f)) {
            if (ball.getY() < getY() + 200 &&
                    ball.getY() > getY() - 200) {
                return true;
            }
        }
        return false;
    }

    public void setMovementDirection(float direction) {
        if (direction >= MyGame.height * 0.5f) {
            movingUp = false;
            movingDown = true;
        }
        else {
            movingDown = false;
            movingUp = true;
        }
    }

    public void stopMovementDirection() {
        movingUp = false;
        movingDown = false;
    }

    public void winRound() {
        points += 1;
    }

}
