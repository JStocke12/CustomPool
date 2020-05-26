package com.example;

import java.util.Vector;

public class Board {
    vector ballPos;
    double ballRadius;
    public Board(vector ballPos, double ballRadius) {
        this.ballPos = ballPos;
        this.ballRadius = ballRadius;
    }

    void move(vector v) {
        this.ballPos.sum(true, v);
    }
}
