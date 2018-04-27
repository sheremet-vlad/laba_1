package main;

import java.awt.*;

import static main.Form.defineCoordinates;

public class Circle extends Figure {
    public void paintFigure(Graphics g, int x, int y){
        defineCoordinates(x0,y0,x,y);
        g.drawOval(arrayCoordinates[0],arrayCoordinates[1],arrayCoordinates[2]-arrayCoordinates[0],arrayCoordinates[3]-arrayCoordinates[1]);
        repaint();
    }
}
