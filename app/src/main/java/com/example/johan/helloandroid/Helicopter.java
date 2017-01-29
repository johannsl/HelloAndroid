package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;

import sheep.game.Sprite;
import sheep.graphics.Color;
import sheep.graphics.Font;
import sheep.graphics.Image;
import sheep.graphics.SpriteView;

/**
 * Created by johan on 27/01/17.
 */

public class Helicopter extends Sprite {

    private final int VELOCITY = 200;
    private Image[] images;
    private float[] vector;
    private Font font;
    private float timer;
    private int frame;

    public Helicopter(Image image) {
        super(image);
        images = new Image[] {image, new Image(R.drawable.heli2), new Image(R.drawable.heli2),
                new Image(R.drawable.heli3)};
        setPosition(1000, 1000);
        vector = new float[] {1f, 0f};
        font = new Font(0, 0, 0, (MyGame.width * 0.04f), Typeface.SANS_SERIF, Typeface.NORMAL);
        timer = 0;
        frame = 1;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText("X Coordinate: " + Math.round(getX() * 100) / 100,
                (MyGame.width * 0.65f), (MyGame.height * 0.03f), font);
        canvas.drawText("Y Coordinate: " + Math.round(getY() * 100) / 100,
                (MyGame.width * 0.65f), (MyGame.height * 0.06f), font);
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
        timer += dt;
        if (timer >= 0.1) {
            setView((SpriteView)images[frame]);
            timer = 0;
            frame = (frame + 1) % images.length;
        }
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
