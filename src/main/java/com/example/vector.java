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

    public vector sum(boolean b, vector v){
        double[] calc = new double[]{this.x()+v.x(), this.y()+v.y()};
        if(b){
            this.pos = calc;
        }
        return new vector(calc[0], calc[1]);
    }

    public vector sub(vector v){
        return new vector(this.x()-v.x(),this.y()-v.y());
    }

    public vector sub(boolean b, vector v){
        double[] calc = new double[]{this.x()-v.x(), this.y()-v.y()};
        if(b){
            this.pos = calc;
        }
        return new vector(calc[0], calc[1]);
    }

    public vector smult(double a){
        return new vector(this.x()*a, this.y()*a);
    }

    public vector smult(boolean b, double a){
        double[] calc = new double[]{this.x()*a, this.y()*a};
        if(b){
            this.pos = calc;
        }
        return new vector(calc[0], calc[1]);
    }

    public vector mmult(vector[] matr){
        return new vector(this.dot(matr[0]), this.dot(matr[1]));
    }

    public vector mmult(boolean b, vector[] matr){
        double[] calc = new double[]{this.dot(matr[0]), this.dot(matr[1])};
        if(b){
            this.pos = calc;
        }
        return new vector(calc[0], calc[1]);
    }

    public double mag(){
        return Math.sqrt(this.dot(this));
    }
}
