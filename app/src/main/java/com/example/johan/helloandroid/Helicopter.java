package com.example.johan.helloandroid;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 27/01/17.
 */

public class Helicopter extends Sprite {

    private final int VELOCITY = 100;
    private float[] coordinates;
    private float[] vector;

    public Helicopter(Image image) {
        super(image);
        setPosition(1000, 1000);
        coordinates = new float[] {1000f, 1000f};
        vector = new float[] {1f, 0f};
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        

    }

    public void setVector(float[] coordinates) {
        this.vector[0] = coordinates[0] - this.coordinates[0];
        this.vector[1] = coordinates[1] - this.coordinates[1];
        this.vector = normalize(this.vector);

        for (float element : this.vector){
            System.out.println("VECTOR ###### " + element);
        }
    }

    private float[] normalize(float[] vector) {
        float temp = vector[0] / (Math.abs(vector[0]) + Math.abs(vector[1]));
        vector[1] = vector[1] / (Math.abs(vector[0]) + Math.abs(vector[1]));
        vector[0] = temp;
        return vector;
    }
}
