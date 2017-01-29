package com.example.johan.helloandroid;

/**
 * Created by johan on 26/01/17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import sheep.game.Game;

public class MyGame extends AppCompatActivity {

    public static int height;
    public static int width;
    private TextView coordinateText;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findScreenMetrics();
        placeCoordinatesOnScreen();
        Game game = new Game(this, null);
        game.pushState(new GameState());
        setContentView(game);
    }

    private void findScreenMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels;
        width = metrics.widthPixels;
    }

    private void placeCoordinatesOnScreen() {
        LinearLayout coordinateView = new LinearLayout(this);
        coordinateText = new TextView(this);
        coordinateText.setText("LOL");
        coordinateView.addView(coordinateText);
        //setContentView(coordinateView);
    }
}
