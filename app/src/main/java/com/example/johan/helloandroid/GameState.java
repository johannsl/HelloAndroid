package com.example.johan.helloandroid;

/**
 * Created by johan on 26/01/17.
 */

import sheep.game.Sprite;
import sheep.game.State;
import sheep.game.World;
import sheep.graphics.Image;
import sheep.input.KeyboardListener;
import sheep.input.Touch;
import sheep.input.TouchListener;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class GameState extends State implements TouchListener {

    private World gameWorld;
    private GameLayer gameLayer;

    public GameState() {
        gameWorld = new World();
        gameLayer = new GameLayer();
        gameWorld.addLayer(gameLayer);
        this.addKeyboardListener(this);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        gameWorld.draw(canvas);
    }

    @Override
    public void update(float dt) {
        gameWorld.update(dt);
    }

    public boolean onTouchDown(MotionEvent event){
        float[] vector = new float[2];
        vector[0] = event.getX();
        vector[1] = event.getY();
        gameLayer.getHeli().setVector(vector);
        return true;
    }
}