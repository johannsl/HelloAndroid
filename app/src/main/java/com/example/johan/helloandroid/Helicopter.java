package com.example.johan.helloandroid;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 27/01/17.
 */

public class Helicopter extends Sprite {

    private final int VELOCITY = 1000;
    private float[] vector;

    public Helicopter(Image image) {
        super(image);
        setPosition(1000, 1000);
        vector = new float[] {1f, 0f};
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        checkWallCollision();
        setImageDirection();
        moveHelicopter(dt);
    }

    private void setImageDirection() {
        if (this.vector[0] >= 0) {
            setScale(-1, 1);
        }
        else { setScale(1, 1); }
    }

    private void checkWallCollision() {
        if (getX() >= MyGame.width && vector[0] >= 0) {
            vector[0] = -vector[0];
        }
        else if (getX() <= 0 && vector[0] <= 0) {
            vector[0] = -vector[0];
        }
        if (getY() >= MyGame.height && vector[1] >= 0) {
            vector[1] = -vector[1];
        }
        else if (getY() <= 0 && vector[1] <= 0) {
            vector[1] = -vector[1];
        }
    }

    private void moveHelicopter(float dt) {
        float dx = dt * VELOCITY * vector[0];
        float dy = dt * VELOCITY * vector[1];
        setPosition(getX() + dx, getY() + dy);
    }

    public void setVector(float[] coordinates) {
        this.vector[0] = coordinates[0] - getX();
        this.vector[1] = coordinates[1] - getY();
        this.vector = normalize(this.vector);
    }

    private float[] normalize(float[] vector) {
        float temp = vector[0] / (Math.abs(vector[0]) + Math.abs(vector[1]));
        vector[1] = vector[1] / (Math.abs(vector[0]) + Math.abs(vector[1]));
        vector[0] = temp;
        return vector;
    }
}
