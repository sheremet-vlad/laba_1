package main;

import java.awt.*;

import static main.Form.defineCoordinates;

public class Circle extends Figure {
    public static int width = 0;
    public void paintFigure(Graphics g, int x, int y){
        if (x0 < x){
            width = x - x0;
            if(y0 < y){
                g.drawOval(x0,y0,width,width);
            }
            else {
                g.drawOval(x0,y0-width,width,width);
            }
        }
        else {
            width = x0 - x;
            if(y0 < y){
                g.drawOval(x,y0,width,width);
            }
            else {
                g.drawOval(x,y0-width,width,width);
            }
        }
    }
}
