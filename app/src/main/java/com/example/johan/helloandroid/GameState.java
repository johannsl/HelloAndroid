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

public class GameState extends State implements TouchListener {

    private World gameWorld;
    private GameLayer gameLayer;
    private float[] coordinates;

    public GameState() {
        gameWorld = new World();
        gameLayer = new GameLayer();
        gameWorld.addLayer(gameLayer);
        this.addKeyboardListener(this);
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

    public boolean onTouchDown(MotionEvent event){
        coordinates[0] = event.getX();
        coordinates[1] = event.getY();
        gameLayer.getHelicopter().setVector(coordinates);
        return true;
    }
}