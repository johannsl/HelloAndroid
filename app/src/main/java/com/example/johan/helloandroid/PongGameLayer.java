package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.view.MotionEvent;

import sheep.game.Layer;
import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;
import sheep.math.BoundingBox;

/**
 * Created by johan on 30/01/17.
 */

public class PongGameLayer extends Layer {

    private Paddle[] paddles;
    private Ball ball;

    public PongGameLayer() {
        paddles = new Paddle[2];
        //paddle[0] = new Paddle();
        //ball = new Ball();
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        //paddle[0].update(dt);

    }

    @Override
    public void update(float dt) {

    }
}
