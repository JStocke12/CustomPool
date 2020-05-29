package com.example;

import com.example.Board;
import com.example.vector;
import com.example.VPolygon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable, MouseListener {

    Image offscreenImage;
    Graphics offscreenGraphics;
    Board board = new Board(new vector(200,200), 20.0);
    JFrame jf = new JFrame();

    Game() {
        Thread u = new Thread(this);
        u.start();
        jf.getContentPane().add(this, BorderLayout.CENTER);
        jf.setSize(new Dimension(500,500+30));
        jf.setVisible(true);
        jf.getContentPane().addMouseListener(this);
    }

    public void run() {
        for(;;){
            try {
                Thread.sleep(16, 667000);
            } catch (InterruptedException e) {}
            repaint();
            board.update();
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
        vector ballPos = board.ballPos.sum(new vector(1,1).smult(board.ballRadius).smult(0.5));
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
        offscreenGraphics.fillOval((int) board.ballPos.x(), (int) board.ballPos.y(), (int) board.ballRadius, (int) board.ballRadius);
        g.drawImage(offscreenImage, 0, 0, this);
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){
        board.hit(new vector(e.getX(), e.getY()).sub(board.ballPos).smult(0.05));
    }

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}