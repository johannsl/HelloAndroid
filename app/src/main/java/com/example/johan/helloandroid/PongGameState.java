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
    private float[] coordinates;

    public PongGameState() {
        gameWorld = new World();
        gameLayer = new PongGameLayer();
        gameWorld.addLayer(gameLayer);
        coordinates = new float[2];
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
        return true;
    }

}