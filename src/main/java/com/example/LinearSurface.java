package com.example;

public class LinearSurface extends Surface {
    vector[] points;

    public LinearSurface(vector p1, vector p2){
        this.points = new vector[]{p1,p2};
    }

    @Override
    public vector[] collisionCheck(Ball ball){
        double reflectAngle = Math.atan(this.points[0].sub(this.points[1]).y()/this.points[0].sub(this.points[1]).x())+Math.PI/2;
        vector[] bounceMatrix = new vector[]{new vector(-Math.cos(2*reflectAngle),-Math.sin(2*reflectAngle)),new vector(-Math.sin(2*reflectAngle),Math.cos(2*reflectAngle))};
        vector offset1 = points[0].sub(points[1]).mmult(new vector[]{new vector(0,1),new vector(-1,0)}).smult(20/points[0].sub(points[1]).mag());
        double t1 = ball.pos.sub(points[0].sum(offset1)).cross(ball.velocity)/points[1].sub(points[0]).cross(ball.velocity);
        double u1 = points[0].sum(offset1).sub(ball.pos).cross(points[1].sub(points[0]))/ball.velocity.cross(points[1].sub(points[0]));
        boolean intersect1 = (this.points[0].sub(this.points[1]).cross(ball.velocity) != 0)&&(u1>=0&&u1<=1)&&(t1>=0&&t1<=1);
        vector offset2 = points[0].sub(points[1]).mmult(new vector[]{new vector(0,-1),new vector(1,0)}).smult(20/points[0].sub(points[1]).mag());
        double t2 = ball.pos.sub(points[0].sum(offset2)).cross(ball.velocity)/points[1].sub(points[0]).cross(ball.velocity);
        double u2 = points[0].sum(offset2).sub(ball.pos).cross(points[1].sub(points[0]))/ball.velocity.cross(points[1].sub(points[0]));
        boolean intersect2 = (this.points[0].sub(this.points[1]).cross(ball.velocity) != 0)&&(u2>=0&&u2<=1)&&(t2>=0&&t2<=1);
        if(intersect1||intersect2){
            return new vector[]{ball.velocity.smult(u1).sum(ball.velocity.smult(1-u1).mmult(bounceMatrix)),ball.velocity.mmult(bounceMatrix)};
        }
        return new vector[]{};
    }
}
