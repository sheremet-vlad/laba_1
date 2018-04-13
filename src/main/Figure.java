package main;

import javax.swing.*;
import java.awt.*;

public abstract class Figure extends JPanel {

    public abstract void paintFigure(Graphics g);
    public static int y0,y1,x0,x1;

    public static int getY0() {
        return y0;
    }

    public static int getY1() {
        return y1;
    }

    public static int getX0() {
        return x0;
    }

    public static int getX1() {
        return x1;
    }

    public static void setY0(int y0) {
        Figure.y0 = y0;
    }

    public static void setY1(int y1) {
        Figure.y1 = y1;
    }

    public static void setX0(int x0) {
        Figure.x0 = x0;
    }

    public static void setX1(int x1) {
        Figure.x1 = x1;
    }
}
