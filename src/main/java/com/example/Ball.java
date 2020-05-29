package com.example;

public class Ball {
    vector pos;
    double radius = 20.0;
    vector velocity = new vector(0,0);

    public Ball(vector pos){
        this.pos = pos;
    }

    void update(){
        this.pos.sum(true, velocity);
        this.velocity.sub(true, this.velocity.smult(0.005));
        if(this.velocity.dot(this.velocity) < 0.04){
            this.velocity = new vector(0,0);
        }
    }
}
