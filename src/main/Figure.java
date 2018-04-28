package main;

import javax.swing.*;
import java.awt.*;

public abstract class Figure extends JPanel {

    public abstract void paintFigure(Graphics g, int x, int y);
    public static int y0,x0;
}
