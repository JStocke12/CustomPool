package com.example;

import java.util.Vector;
import com.example.Ball;

public class Board {
    Ball[] balls;
    Surface[] surfaces;

    public Board(Ball[] balls, Surface[] surfaces) {
        this.balls = balls;
        this.surfaces = surfaces;
    }

    void hitQue(vector v) {
        if(this.balls[0].velocity.dot(this.balls[0].velocity) == 0) {
            this.balls[0].velocity = v;
        }
    }

    void update(){
        for(int i = 0; i < balls.length; i++){
            this.balls[i].update();
        }
    }
}
