package com.example;

import java.util.Vector;

public class Board {
    vector ballPos;
    double ballRadius;
    vector velocity = new vector(0,0);

    public Board(vector ballPos, double ballRadius) {
        this.ballPos = ballPos;
        this.ballRadius = ballRadius;
    }

    void hit(vector v) {
        if(this.velocity.dot(this.velocity) == 0) {
            this.velocity = v;
        }
    }

    void update(){
        this.ballPos.sum(true, velocity);
        this.velocity.sub(true, this.velocity.smult(0.005));
        if(this.velocity.dot(this.velocity) < 0.04){
            this.velocity = new vector(0,0);
        }
    }
}
