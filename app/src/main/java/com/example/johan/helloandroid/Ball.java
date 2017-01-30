package com.example.johan.helloandroid;

import android.graphics.Canvas;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 30/01/17.
 */

public class Ball extends Sprite {

    private float velocity;
    private float[] vector;

    public Ball(Image image) {
        velocity = 500f;
        vector = new float[] {-1f, 0f};
        setPosition(MyGame.width * 0.5f, MyGame.height * 0.5f);
        setShape(100, 100);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        checkWallCollision();
        checkPaddleCollision();
        moveBall(dt);
    }

    private void checkWallCollision() {
        if (getY() >= MyGame.height && vector[1] >= 0) {
            vector[1] = -vector[1];
        }
        else if (getY() <= 0 && vector[1] <= 0) {
            vector[1] = -vector[1];
        }
    }

    private void checkPaddleCollision() {

    }

    private void moveBall(float dt) {
        float dx = dt * velocity * vector[0];
        float dy = dt * velocity * vector[1];
        setPosition(getX() + dx, getY() + dy);
    }

}
