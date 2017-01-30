package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;

/**
 * Created by johan on 30/01/17.
 */

public class PongGameState extends State implements TouchListener {

    private World gameWorld;
    private PongGameLayer gameLayer;
    private float direction;

    public PongGameState() {
        gameWorld = new World();
        gameLayer = new PongGameLayer();
        gameWorld.addLayer(gameLayer);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        gameWorld.draw(canvas);
    }

    @Override
    public void update(float dt) { gameWorld.update(dt); }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        direction = event.getY();
        gameLayer.getPaddle().setMovementDirection(direction);
        return true;
    }

    @Override
    public boolean onTouchUp(MotionEvent event) {
        gameLayer.getPaddle().stopMovementDirection();
        return true;
    }

}