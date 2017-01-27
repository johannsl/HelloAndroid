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
    private static int height;
    private static int width;

    public GameState() {
        gameWorld = new World();
        gameLayer = new GameLayer();
        gameWorld.addLayer(gameLayer);
        this.addKeyboardListener(this);
        height = MyGame.height;
        width = MyGame.width;
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        gameWorld.draw(canvas);
    }

    public void update(float dt) {
        gameWorld.update(dt);
    }

    public boolean onTouchDown(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        if (x < width/2 || y < height/2) {
            Heli.setMoveRight();
        }


        return true;
    }
}