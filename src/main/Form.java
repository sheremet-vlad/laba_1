package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import static main.Main_class.arrayCoordinates;
import static main.Main_class.listFigure;

public class Form extends JFrame implements MouseListener, MouseMotionListener {

    public Figure activeFigure = new NonChooseFigure();
    private ButtonGroup  typeFigure = new ButtonGroup();
    int mouseX,mouseY;


    private JRadioButton    radioCircle = new JRadioButton("Круг",false),
                            radioRectangle = new JRadioButton("Прямоугольник", false),
                            radioOval = new JRadioButton("Овал", false),
                            radioSegment = new JRadioButton("Отрезок", false),
                            radioSquare = new JRadioButton("Квадрат", false),
                            radioTriangle = new JRadioButton("Треуггольник", false);



    public Form() {
        setLayout(null);

        //радио группа
        typeFigure.add(radioTriangle);
        typeFigure.add(radioRectangle);
        typeFigure.add(radioCircle);
        typeFigure.add(radioOval);
        typeFigure.add(radioSegment);
        typeFigure.add(radioSquare);

        int width = 100, height = 50, y = 20;

        //добавление компонентов
        add(radioCircle).setBounds(50,y,width-50,height);
        add(radioRectangle).setBounds(120,y,width+20,height);
        add(radioTriangle).setBounds(240,y,width+20,height);
        add(radioOval).setBounds(360,y,width,height);
        add(radioSegment).setBounds(460,y,width,height);
        add(radioSquare).setBounds(560,y,width,height);
        //add(buttonDraw).setBounds(250,70,150,40);

        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void mouseDragged(MouseEvent me) {
        // сохранить координаты
        mouseX = me.getX();
        mouseY = me.getY();
        if (radioCircle.isSelected()){
            activeFigure = listFigure.get(0);
        } else if (radioRectangle.isSelected()) {
            activeFigure = listFigure.get(1);
        } else if (radioOval.isSelected()) {
            activeFigure = listFigure.get(2);
        } else if (radioSegment.isSelected()) {
            activeFigure = listFigure.get(3);
        } else if (radioSquare.isSelected()) {
            activeFigure = listFigure.get(4);
        } else if (radioTriangle.isSelected()) {
            activeFigure = listFigure.get(5);
        } else {
            activeFigure = listFigure.get(6);
        }
        repaint();
    }


    public void mousePressed(MouseEvent me) {
        activeFigure.x0 = me.getX();
        activeFigure.y0 = me.getY();
        activeFigure = listFigure.get(6);
        repaint();
    }


    public void mouseReleased(MouseEvent me) {

    }


    public void paint(Graphics g) {
        super.paint(g);

        activeFigure.paintFigure(g,mouseX,mouseY);
    }

    public void mouseClicked(MouseEvent me) {
        activeFigure = new NonChooseFigure();
        super.repaint();
    }


    public static void defineCoordinates(int x0, int y0, int x1, int y1 ) {
        if (x0 <= x1) {
            if (y0 <= y1) {
                arrayCoordinates[0] = x0;
                arrayCoordinates[1] = y0;
                arrayCoordinates[2] = x1;
                arrayCoordinates[3] = y1;
            } else {
                arrayCoordinates[0] = x0;
                arrayCoordinates[1] = y1;
                arrayCoordinates[2] = x1;
                arrayCoordinates[3] = y0;
            }
        } else {
            if (y0 <= y1) {
                arrayCoordinates[0] = x1;
                arrayCoordinates[1] = y0;
                arrayCoordinates[2] = x0;
                arrayCoordinates[3] = y1;
            } else {
                arrayCoordinates[0] = x1;
                arrayCoordinates[1] = y1;
                arrayCoordinates[2] = x0;
                arrayCoordinates[3] = y0;
            }
        }
    }



    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void mouseMoved(MouseEvent me) {

    }
}
