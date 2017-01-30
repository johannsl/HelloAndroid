package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import sheep.game.State;
import sheep.graphics.Font;
import sheep.gui.TextButton;
import sheep.gui.WidgetAction;
import sheep.gui.WidgetListener;

/**
 * Created by johan on 30/01/17.
 */

public class MenuState extends State implements WidgetListener {

    private TextButton startHelicopterMode;
    private TextButton startPongMode;
    private static Paint paint;

    public MenuState() {
        paint = new Paint();
        paint.setARGB(255, 255, 255, 255);
        paint.setTextSize(100f);
        startHelicopterMode = new TextButton(MyGame.width * 0.1f, MyGame.height * 0.3f,
                "Start Helicopter Mode", new Paint[] {paint, paint});
        startPongMode = new TextButton(MyGame.width * 0.1f, MyGame.height * 0.6f,
                "Start Pong Mode", new Paint[] {paint, paint});
        startHelicopterMode.addWidgetListener(this);
        startPongMode.addWidgetListener(this);
        addTouchListener(startHelicopterMode);
        addTouchListener(startPongMode);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        startHelicopterMode.draw(canvas);
        startPongMode.draw(canvas);
    }

    @Override
    public void actionPerformed(WidgetAction action) {
        if (action.getSource() == startHelicopterMode) {
            getGame().popState();
            getGame().pushState(new HelicopterGameState());
        }
        else if (action.getSource() == startPongMode) {
            getGame().popState();
            getGame().pushState(new PongGameState());
        }
    }


}
