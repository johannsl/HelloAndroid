package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;

import java.util.ArrayList;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.Touch;

/**
 * Created by johan on 27/01/17.
 */

public class Heli extends Sprite {

    private final int VELOCITY = 100;
    //private ArrayList<Float> vector;
    private float posX;
    private float posY;
    private float[] vector;

    public Heli(Image image) {
        super(image);
        setPosition(200, 200);
        vector = new float[2];
    }

    @Override
    public void update(float dt) {
        super.update(dt);

    }

    public void setVector(float[] vector) {
        for (float element : vector){
            System.out.println("VECTOR ###### " + element);
        }
        float[] normalized = normalize(vector);
        for (float element : normalized){
            System.out.println("NORM ###### " + element);
        }
        float[] centralized = centralize(vector);
        for (float element : centralized){
            System.out.println("CENTR ###### " + element);
        }

        this.vector = normalized;
        return;
    }

    private float[] centralize(float[] vector) {
        float[] centralized = new float[2];
        centralized[0] = vector[0] - (MyGame.width / 2);
        centralized[1] = vector[1] - (MyGame.height / 2);
        System.out.println(centralized);
        return centralized;
    }

    private float[] normalize(float[] vector) {
        float[] normalized = new float[2];
        normalized[0] = vector[0] / (vector[0] + vector[1]);
        normalized[1] = vector[1] / (vector[0] + vector[1]);
        System.out.println(normalized);
        return normalized;
    }


}
