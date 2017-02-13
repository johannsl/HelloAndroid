package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;

import sheep.collision.CollisionListener;
import sheep.game.Sprite;
import sheep.graphics.Color;
import sheep.graphics.Font;
import sheep.graphics.Image;
import sheep.graphics.SpriteView;

/**
 * Created by johan on 27/01/17.
 */

public class Helicopter extends Sprite {

    private final float VELOCITY;
    private static Image[] images;
    private static Font font;
    private float[] vector;
    private float frameTimer;
    private int frame;
    private boolean mainHelicopter;

    public Helicopter(Image image) {
        super(image);
        VELOCITY = (float)Math.random() * 300 + 200;
        images = new Image[] {image, new Image(R.drawable.heli2), new Image(R.drawable.heli3),
                new Image(R.drawable.heli4)};
        font = new Font(0, 0, 0, (MyGame.width * 0.04f), Typeface.SANS_SERIF, Typeface.NORMAL);
        vector = new float[] {(float)Math.random() * 2 - 1, (float)Math.random() * 2 - 1};
        frameTimer = 0f;
        frame = 1;
        mainHelicopter = false;
        setPosition((float)Math.random() * MyGame.width, (float)Math.random() * MyGame.height);
        setShape(600, 200);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (mainHelicopter) {
            canvas.drawText("X Coordinate: " + Math.round(getX() * 100) / 100,
                    (MyGame.width * 0.65f), (MyGame.height * 0.03f), font);
            canvas.drawText("Y Coordinate: " + Math.round(getY() * 100) / 100,
                    (MyGame.width * 0.65f), (MyGame.height * 0.06f), font);
        }
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        updateImage(dt);
        checkWallCollision();
        setImageDirection();
        moveHelicopter(dt);
    }

    private void updateImage(float dt) {
        frameTimer += dt;
        if (frameTimer >= 0.1) {
            setView(images[frame]);
            frameTimer = 0;
            frame = (frame + 1) % images.length;
        }
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

    private void setImageDirection() {
        if (this.vector[0] >= 0) {
            setScale(-1, 1);
        }
        else { setScale(1, 1); }
    }

    private void moveHelicopter(float dt) {
        float dx = dt * VELOCITY * vector[0];
        float dy = dt * VELOCITY * vector[1];
        setPosition(getX() + dx, getY() + dy);
    }

    public void setDirection(float[] coordinates) {
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

    public void setMainHelicopter() {
        mainHelicopter = true;
    }

    public void collide(Helicopter helicopter) {
        float[] coordinates = new float[] {helicopter.getX(), helicopter.getY()};
        setDirection(findRetreatDirection(coordinates));
    }

    private float[] findRetreatDirection(float[] coordinates) {
        float temp = getX() - (coordinates[0] - getX());
        coordinates[1] = getY() - (coordinates[1] - getY());
        coordinates[0] = temp;
        return coordinates;
    }
}
