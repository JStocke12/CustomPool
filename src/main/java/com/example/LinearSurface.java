package com.example;

public class LinearSurface {
    vector[] points;

    public LinearSurface(vector p1, vector p2){
        this.points = new vector[]{p1,p2};
    }

    public vector collisionCheck(){
        return new vector(0,0);
    }
}
