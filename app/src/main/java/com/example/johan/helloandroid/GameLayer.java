package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.view.MotionEvent;

import sheep.game.Layer;
import sheep.graphics.Image;
import sheep.input.TouchListener;
import sheep.math.BoundingBox;

/**
 * Created by johan on 27/01/17.
 */

public class GameLayer extends Layer {

    private Helicopter helicopter;

    public GameLayer() {
        helicopter = new Helicopter(new Image(R.drawable.heli1));
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        helicopter.draw(canvas);
    }

    @Override
    public void update(float dt) {
        helicopter.update(dt);
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }
}