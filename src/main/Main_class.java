package main;

import javax.swing.*;

import java.awt.*;


public class Main_class extends JFrame {
    public static void main(String[] args) {
        //JFrame form = run(new JFrame(),700,700);
        JFrame f = new JFrame("hi");
        f.setSize(500,500);
        f.setVisible(true);
        f.add(new Board());
        System.out.println();
    }

}

class Board extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(100, 100, 200, 200);
    }

}