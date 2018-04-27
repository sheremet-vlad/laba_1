package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static main.Figure.arrayCoordinates;

public class Form extends JFrame implements MouseListener, MouseMotionListener {
    //int x1 = 300,x2 = 300, x3 = 50,x4= 10;
    public Figure activeFigure = new NonChooseFigure();
    private ButtonGroup  typeFigure = new ButtonGroup();
    int mouseX,mouseY;
    public Graphics g1;

    public boolean check = false;

    private JRadioButton    radioCircle = new JRadioButton("Круг",false),
                            radioRectangle = new JRadioButton("Прямоугольник", false),
                            radioRhombus = new JRadioButton("Ромб", false),
                            radioSegment = new JRadioButton("Отрезок", false),
                            radioSquare = new JRadioButton("Квадрат", false),
                            radioTriangle = new JRadioButton("Треуггольник", false);

    private JTextField fieldSize= new JTextField(40);

    public JButton buttonDraw = new JButton("Рисовать");

    public Form() {
        setLayout(null);

        //радио группа
        typeFigure.add(radioTriangle);
        typeFigure.add(radioRectangle);
        typeFigure.add(radioCircle);
        typeFigure.add(radioRhombus);
        typeFigure.add(radioSegment);
        typeFigure.add(radioSquare);

        int width = 100, height = 50, y = 20;


        //добавление компонентов
        add(radioCircle).setBounds(50,y,width-50,height);
        add(radioRectangle).setBounds(120,y,width+20,height);
        add(radioTriangle).setBounds(240,y,width+20,height);
        add(radioRhombus).setBounds(360,y,width,height);
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
            activeFigure = new Circle();
        } else if (radioRectangle.isSelected()) {
            activeFigure = new Rectangle();
        } else if (radioRhombus.isSelected()) {
            activeFigure = new Rhombus();
        } else if (radioSegment.isSelected()) {
            activeFigure = new Segment();
        } else if (radioSquare.isSelected()) {
            activeFigure = new Square();
        } else if (radioTriangle.isSelected()) {
            activeFigure = new Triangle();
        } else {
            activeFigure = new NonChooseFigure();
        }
        repaint();
    }

    public void mousePressed(MouseEvent me) {
        activeFigure.setX0(me.getX());
        activeFigure.setY0(me.getY());
        repaint();
    }


    public void mouseReleased(MouseEvent me) {

    }


    public void paint(Graphics g) {
        super.paint(g);
        //g.setColor(Color.BLACK);
        activeFigure.paintFigure(g,mouseX,mouseY);
    }

    public void mouseClicked(MouseEvent me) {
        activeFigure = new NonChooseFigure();
        super.repaint();
    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {

    }

    public void mouseMoved(MouseEvent me) {

    }

    public static void defineCoordinates(int x0, int y0, int x1, int y1 ) {
        if (x0 < x1) {
            if (y0 < y1) {
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
            if (y0 < y1) {
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
}
