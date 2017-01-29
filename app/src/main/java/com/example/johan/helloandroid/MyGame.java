package com.example.johan.helloandroid;

/**
 * Created by johan on 26/01/17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import sheep.game.Game;

public class MyGame extends AppCompatActivity {

    public static int height;
    public static int width;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels;
        width = metrics.widthPixels;

        super.onCreate(savedInstanceState);
        // Create the game.
        Game game = new Game(this, null);
        // Push the main state.
        game.pushState(new GameState());
        // View the game.
        setContentView(game);
    }
}
