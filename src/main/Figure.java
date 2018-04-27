package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Figure extends JPanel {

    public abstract void paintFigure(Graphics g, int x, int y);
    public static int y0,x0;
    public static int[] arrayCoordinates = new int[4];

    public static int getY0() {
        return y0;
    }

    public static void setX0(int x0) {
        Figure.x0 = x0;
    }

    public static int getX0() {
        return x0;
    }

    public static void setY0(int y0) {
        Figure.y0 = y0;
    }

}
