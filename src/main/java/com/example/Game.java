package com.example;

import com.example.Board;
import com.example.vector;
import com.example.VPolygon;
import java.awt.*;
import javax.swing.*;

public class Game extends Canvas implements Runnable {

    Image offscreenImage;
    Graphics offscreenGraphics;
    Board board = new Board(new double[]{200.0,200.0,20.0,20.0});
    JFrame jf = new JFrame();

    Game() {
        Thread u = new Thread(this);
        u.start();
        jf.getContentPane().add(this, BorderLayout.CENTER);
        jf.setSize(new Dimension(500,500+30));
        jf.setVisible(true);
    }

    public void run() {
        for(;;){
            try {
                Thread.sleep(16, 667000);
            } catch (InterruptedException e) {}
            repaint();
        }
    }

    public void paint(Graphics g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        offscreenImage = createImage(size().width, size().height);
        offscreenGraphics = offscreenImage.getGraphics();
        offscreenGraphics.setColor(new Color(0,127,0));
        offscreenGraphics.fillRect(0,0,size().width, size().height);
        offscreenGraphics.setColor(new Color(200,200,200));
        vector mousePos = new vector((int) MouseInfo.getPointerInfo().getLocation().getX(), (int) MouseInfo.getPointerInfo().getLocation().getY());
        vector contentPos = new vector(jf.getX(), jf.getY());
        vector ballPos = new vector(board.ball[0]+board.ball[2]/2, board.ball[1]+board.ball[3]/2);
        vector relMousePos = mousePos.sub(contentPos).sub(new vector(8,30));
        vector rotBallMousePos = relMousePos.sub(ballPos).mmult(new vector[]{new vector(0,1),new vector(-1,0)});
        double arrowLength = relMousePos.sub(ballPos).mag();
        if(arrowLength != 0){
            vector arrowBaseWidth = rotBallMousePos.smult(5/arrowLength);
            VPolygon arrow = new VPolygon();
            arrow.addPoint(ballPos.sum(arrowBaseWidth));
            arrow.addPoint(ballPos.sub(arrowBaseWidth));
            arrow.addPoint(relMousePos);
            offscreenGraphics.fillPolygon(arrow);
        }
        offscreenGraphics.setColor(new Color(255,255,255));
        offscreenGraphics.fillOval((int) board.ball[0], (int) board.ball[1], (int) board.ball[2], (int) board.ball[3]);
        g.drawImage(offscreenImage, 0, 0, this);
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}