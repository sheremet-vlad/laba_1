package main;

import javax.swing.*;

import java.util.ArrayList;

import static create_gui_form.SwingConsole.run;


public class Main_class extends JFrame {
    public static ArrayList<Figure> listFigure;
    public static int[] arrayCoordinates = new int[4];
    public static void main(String[] args) {

        //создание списка Фигур
        listFigure = new ArrayList<>();
        listFigure.add(new Circle());
        listFigure.add(new Rectangle());
        listFigure.add(new Oval());
        listFigure.add(new Segment());
        listFigure.add(new Square());
        listFigure.add(new Triangle());
        listFigure.add(new NonChooseFigure());

        JFrame form = run(new Form(),700,700);
    }

}

