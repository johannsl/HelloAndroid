package com.example.johan.helloandroid;

import android.graphics.Canvas;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by johan on 13/02/17.
 */

public class ControlPaddle extends Paddle {

    public ControlPaddle(Image image) {
        super(image);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(points + "", (MyGame.width * 0.05f), (MyGame.height * 0.15f), font);
    }

    @Override
    protected void checkWallCollision() {
        if (getY() >= MyGame.height * 0.7f && movingDown) {
            movingDown = false;
        }
        else if (getY() <= MyGame.height * 0.1f && movingUp) {
            movingUp = false;
        }
    }

    @Override
    public boolean collides(Sprite sprite) {
        Ball ball = (Ball) sprite;
        if (ball.getX() <= MyGame.width * 0.1f) {
            if (ball.getY() < getY() + 200 && ball.getY() > getY() - 200) {
                return true;
            }
        }
        return false;
    }

    public void setMovementDirection(float direction) {
        if (direction >= MyGame.height * 0.5f) {
            movingUp = false;
            movingDown = true;
        }
        else {
            movingDown = false;
            movingUp = true;
        }
    }

    public void stopMovementDirection() {
        movingUp = false;
        movingDown = false;
    }
}
