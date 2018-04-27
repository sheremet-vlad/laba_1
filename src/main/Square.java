package main;

import java.awt.*;

import static main.Form.defineCoordinates;

public class Square extends Figure {
    public void paintFigure(Graphics g, int x, int y){
        defineCoordinates(x0,y0,x,y);
        x = arrayCoordinates[2] - arrayCoordinates[0];
        y = arrayCoordinates[3] - arrayCoordinates[1];
        if (x > y){
            g.drawRect(arrayCoordinates[0],arrayCoordinates[1],x,x);
        }
        else {
            g.drawRect(arrayCoordinates[0],arrayCoordinates[1],y,y);
        }

        repaint();
    }
}
