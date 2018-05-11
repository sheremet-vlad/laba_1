package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


import static main.Main_class.arrayCoordinates;

public class Form extends JFrame implements MouseListener, MouseMotionListener {

    public Figure activeFigure = new NonChooseFigure();
    private ButtonGroup  typeFigure = new ButtonGroup();
    int mouseX,mouseY;
    public static ArrayList<Figure> listOfFigure = new ArrayList<>();

    private JButton buttonClear = new JButton("Очистить");


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
        add(radioCircle).setBounds(10,y,width-50,height);
        add(radioRectangle).setBounds(80,y,width+20,height);
        add(radioTriangle).setBounds(200,y,width+20,height);
        add(radioOval).setBounds(320,y,width-40,height);
        add(radioSegment).setBounds(380,y,width,height);
        add(radioSquare).setBounds(480,y,width-20,height);
        add(buttonClear).setBounds(570,y+10,100,30);
        //add(buttonDraw).setBounds(250,70,150,40);

        addMouseListener(this);
        addMouseMotionListener(this);

        buttonsAction();
    }

    private void buttonsAction(){
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfFigure.clear();
                repaint();
                activeFigure = new NonChooseFigure();
            }
        });
    }


    public void mouseDragged(MouseEvent me) {
        // сохранить координаты
        mouseX = me.getX();
        mouseY = me.getY();
        if (radioCircle.isSelected()){
            activeFigure = new Circle();
            repaint();
        } else if (radioRectangle.isSelected()) {
            activeFigure = new Rectangle();
            repaint();
        } else if (radioOval.isSelected()) {
            activeFigure = new Oval();
            repaint();
        } else if (radioSegment.isSelected()) {
            activeFigure = new Segment();
            repaint();
        } else if (radioSquare.isSelected()) {
            activeFigure = new Square();
            repaint();
        } else if (radioTriangle.isSelected()) {
            activeFigure = new Triangle();
            repaint();
        }
    }


    public void mousePressed(MouseEvent me) {
        activeFigure.xStart = me.getX();
        activeFigure.yStart = me.getY();
        repaint();
    }


    public void mouseReleased(MouseEvent me) {
        activeFigure.setX(activeFigure.xStart);
        activeFigure.setY(activeFigure.yStart);
        activeFigure.setX1(me.getX());
        activeFigure.setY1(me.getY());
        listOfFigure.add(activeFigure);
    }


    public void paint(Graphics g) {
        super.paint(g);

        for (Figure temp : listOfFigure){
            temp.paintFigure(g,temp.getX1(),temp.getY1(),temp.getX(),temp.getY());
        }

        activeFigure.paintFigure(g,mouseX,mouseY,activeFigure.xStart,activeFigure.yStart);
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
