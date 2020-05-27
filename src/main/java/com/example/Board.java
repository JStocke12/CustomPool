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
        this.velocity = v;
        System.out.println("Hello World!");
    }

    void update(){
        this.ballPos.sum(velocity);
    }
}
