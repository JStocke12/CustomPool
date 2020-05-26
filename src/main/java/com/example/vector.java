package com.example;

public class vector {
    double[] pos;

    public vector(double x, double y){
        this.pos = new double[]{x,y};
    }

    public double x(){
        return this.pos[0];
    }

    public double y(){
        return this.pos[1];
    }

    public double dot(vector v){
        double out = 0;
        for(int i=0;i<2;i++){
            out += v.pos[i]*this.pos[i];
        }
        return out;
    }

    public vector sum(vector v){
        return new vector(this.x()+v.x(),this.y()+v.y());
    }

    public vector sub(vector v){
        return new vector(this.x()-v.x(),this.y()-v.y());
    }

    public vector mmult(vector[] matr){
        this.pos = new double[]{this.dot(matr[0]), this.dot(matr[1])};
        return this;
    }

    public double mag(){
        return Math.sqrt(this.dot(this));
    }
}
