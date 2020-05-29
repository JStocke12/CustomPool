package com.example;

public class LinearSurface extends Surface {
    vector[] points;

    public LinearSurface(vector p1, vector p2){
        this.points = new vector[]{p1,p2};
    }

    @Override
    public vector collisionCheck(vector velocity){
        return new vector(0,0);
    }
}
