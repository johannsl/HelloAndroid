package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.view.MotionEvent;

import sheep.game.Layer;
import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;
import sheep.math.BoundingBox;

/**
 * Created by johan on 27/01/17.
 */

public class GameLayer extends Layer {

    private Helicopter[] helicopters;

    public GameLayer() {
        helicopters = new Helicopter[2];
        for (int i=0; i<2; i++) {
            helicopters[i] = new Helicopter(new Image(R.drawable.heli1));
        }
        helicopters[0].setMainHelicopter();
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        for (Helicopter helicopter : helicopters) {
            helicopter.draw(canvas);
        }
    }

    @Override
    public void update(float dt) {
        checkCollisions();
        for (Helicopter helicopter : helicopters) {
            helicopter.update(dt);
        }
    }

    private void checkCollisions() {
        for (Helicopter helicopter : helicopters) {
            for (Helicopter helicopter1 : helicopters) {
                if (helicopter != helicopter1 && helicopter.collides(helicopter1)) {
                    helicopter.collide(helicopter1);
                    //break;
                }
            }
        }
    }

    public Helicopter getHelicopter() {
        return helicopters[0];
    }
}