package com.example.johan.helloandroid;

import android.graphics.Canvas;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 30/01/17.
 */

public class Ball extends Sprite {

    private static final Ball BALL = new Ball(new Image(R.drawable.ball));

    private float velocity;
    private float[] vector;
    private float crashTimer;

    private Ball(Image image) {
        super(image);
        velocity = 400f;
        vector = new float[] {-1f, 0f};
        crashTimer = 0f;
        setPosition(MyGame.width * 0.5f, MyGame.height * 0.5f);
        setScale(0.5f, 0.5f);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        crashTimer += dt;
        checkWallCollision();
        moveBall(dt);
    }

    private void checkWallCollision() {
        if (getY() >= MyGame.height * 0.7f && vector[1] >= 0) {
            vector[1] = -vector[1];
        }
        else if (getY() <= MyGame.height * 0.1f && vector[1] <= 0) {
            vector[1] = -vector[1];
        }
    }

    private void moveBall(float dt) {
        float dx = dt * velocity * vector[0];
        float dy = dt * velocity * vector[1];
        setPosition(getX() + dx, getY() + dy);
    }

    public void collide(float dt, Paddle paddle) {
        if (crashTimer >= 2f) {
            vector[0] = -vector[0];
            vector[1] = (paddle.getY() - getY()) / -paddle.getY();
            crashTimer = 0f;
        }
    }

    public int checkWinningPlayer() {
        int winningPlayer = 0;
        if (getX() >= MyGame.width && vector[0] >= 0) {
            winningPlayer = 1;
            resetBall();
        }
        else if (getX() <= 0 && vector[0] <= 0) {
            winningPlayer = 2;
            resetBall();
        }
        return winningPlayer;
    }

    private void resetBall() {
        setPosition(MyGame.width * 0.5f, MyGame.height * 0.5f);
        vector = new float[] {-1f, 0f};
        crashTimer = 0f;
    }

    public static Ball getBall() {
        return BALL;
    }

}
