package main;

import java.awt.*;

public class Triangle extends Figure {
    public void paintFigure(Graphics g, int x, int y){
        // g.setColor(Color.BLACK);
        g.fillRect(x0,y0,x-x0,y-y0);
        // g.drawLine(x0,y0,x,y);
        repaint();
    }
}
