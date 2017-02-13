package com.example.johan.helloandroid;

import android.graphics.Canvas;
import android.view.MotionEvent;

import sheep.game.Layer;
import sheep.game.State;
import sheep.game.World;
import sheep.graphics.Image;
import sheep.input.TouchListener;
import sheep.math.BoundingBox;

/**
 * Created by johan on 30/01/17.
 */

public class PongGameLayer extends Layer {

    //private Paddle paddle;
    //private Paddle computerPaddle;
    private ControlPaddle controlPaddle;
    private ComputerPaddle computerPaddle;
    private static Ball ball;

    public PongGameLayer() {
        //paddle = new Paddle(new Image(R.drawable.paddle));
        controlPaddle = new ControlPaddle(new Image(R.drawable.paddle));
        computerPaddle = new ComputerPaddle(new Image(R.drawable.paddle));
        //computerPaddle.isBot = true;
        //computerPaddle.setMovementDirection(0f);
        //computerPaddle.setPosition(MyGame.width * 0.985f, MyGame.height * 0.5f);
        //ball = new Ball(new Image(R.drawable.ball));
        ball = Ball.getBall();
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        controlPaddle.draw(canvas);
        computerPaddle.draw(canvas);
        ball.draw(canvas);
    }

    @Override
    public void update(float dt) {
        if (controlPaddle.collides(ball)) {
            ball.collide(dt, controlPaddle);
        }
        else if (computerPaddle.collides(ball)) {
            ball.collide(dt, computerPaddle);
        }
        controlPaddle.update(dt);
        computerPaddle.update(dt);
        ball.update(dt);
        checkRoundOver();
    }

    private void checkRoundOver(){
        int winningPlayer = ball.checkWinningPlayer();
        if (winningPlayer != 0) {
            if (winningPlayer == 1) { controlPaddle.winRound(); }
            else { computerPaddle.winRound(); }
        }
    }

    public Paddle getPaddle() {
        return controlPaddle;
    }
}
