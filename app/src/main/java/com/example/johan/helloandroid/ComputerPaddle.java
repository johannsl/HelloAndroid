package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.support.annotation.VisibleForTesting;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 13/02/17.
 */

public class ComputerPaddle extends Paddle {

    public ComputerPaddle(Image image) {
        super(image);
        movingDown = true;
        setPosition(MyGame.width * 0.985f, MyGame.height * 0.5f);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(points + "", (MyGame.width * 0.95f), (MyGame.height * 0.15f), font);
    }

    @Override
    protected void checkWallCollision() {
        if (getY() >= MyGame.height * 0.7f && movingDown) {
            movingDown = false;
            movingUp = true;
        }
        else if (getY() <= MyGame.height * 0.1f && movingUp) {
            movingUp = false;
            movingDown = true;
        }
    }

    @Override
    public boolean collides(Sprite sprite) {
        Ball ball = (Ball) sprite;
        if (ball.getX() >= MyGame.width * 0.9) {
            if (ball.getY() < getY() + 200 && ball.getY() > getY() - 200) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setMovementDirection(float direction) {}

    @Override
    public void stopMovementDirection() {}
}
