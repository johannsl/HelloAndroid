package com.example.johan.helloandroid;

import android.graphics.Canvas;

import sheep.game.Layer;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by johan on 27/01/17.
 */

public class GameLayer extends Layer {

    private Heli heli1;

    public GameLayer() {
        heli1 = new Heli(new Image(R.drawable.heli1));
    }

    public void draw(Canvas canvas, BoundingBox box) {
        heli1.draw(canvas);
    }

    public void update(float dt) {
        heli1.update(dt);
    }
}