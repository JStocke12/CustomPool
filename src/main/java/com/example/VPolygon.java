package com.example;

import java.awt.Polygon;
import com.example.vector;

public class VPolygon extends Polygon {
    public VPolygon(){
        super();
    }

    public void addPoint(vector v){
        super.addPoint((int) v.x(), (int) v.y());
    }
}
