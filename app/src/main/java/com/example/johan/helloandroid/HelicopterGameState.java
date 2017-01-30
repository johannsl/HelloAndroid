package com.example.johan.helloandroid;

/**
 * Created by johan on 26/01/17.
 */

import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

public class HelicopterGameState extends State implements TouchListener {

    private World gameWorld;
    private HelicopterGameLayer gameLayer;
    private float[] coordinates;

    public HelicopterGameState() {
        gameWorld = new World();
        gameLayer = new HelicopterGameLayer();
        gameWorld.addLayer(gameLayer);
        coordinates = new float[2];
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.MAGENTA);
        gameWorld.draw(canvas);
    }

    @Override
    public void update(float dt) {
        gameWorld.update(dt);
    }

    @Override
    public boolean onTouchDown(MotionEvent event){
        coordinates[0] = event.getX();
        coordinates[1] = event.getY();
        gameLayer.getMainHelicopter().setDirection(coordinates);
        return true;
    }
}