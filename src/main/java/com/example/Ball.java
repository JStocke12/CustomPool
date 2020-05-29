package com.example;

public class Ball {
    vector pos;
    double radius = 20.0;
    vector velocity = new vector(0,0);

    public Ball(vector pos){
        this.pos = pos;
    }

    void update(Surface[] surfaces){
        this.pos.sum(true, velocity);
        this.velocity.sub(true, this.velocity.smult(0.005));
        if(this.velocity.dot(this.velocity) < 0.04){
            this.velocity = new vector(0,0);
        }
        for(int i = 0; i < surfaces.length; i++){
            vector[] collisionCheckOut = surfaces[i].collisionCheck(this);
            if(collisionCheckOut.length == 2){
                if(collisionCheckOut[1].dot(collisionCheckOut[1]) >= 0.04){
                    this.pos.sum(true, collisionCheckOut[0]);
                    this.velocity = collisionCheckOut[1];
                }
            }
        }
    }
}
