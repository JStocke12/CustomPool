package com.example;

import java.util.Vector;

public class Board {
    double[] ball;
    public Board(double[] ball) {
        this.ball = ball;
    }

    void move(double[] vector) {
        this.ball[0] += vector[0];
        this.ball[1] += vector[1];
    }
}
