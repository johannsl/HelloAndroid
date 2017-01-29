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

    private Heli heli1;

    public GameLayer() {
        heli1 = new Heli(new Image(R.drawable.heli1));
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        heli1.draw(canvas);
    }

    @Override
    public void update(float dt) {
        heli1.update(dt);
    }

    public Heli getHeli() {
        return heli1;
    }
}