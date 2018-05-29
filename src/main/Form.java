package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


import static main.Main_class.arrayCoordinates;

public class Form extends JFrame implements MouseListener, MouseMotionListener {

    public Figure activeFigure = new NonChooseFigure();
    private ButtonGroup  typeFigure = new ButtonGroup();
    int mouseX,mouseY;
    public static ArrayList<Figure> listOfFigure = new ArrayList<>();

    private JButton buttonClear = new JButton("Очистить"),
                    buttonSerialize = new JButton("Записать"),
                    buttonLoad = new JButton("Загрузить");


    private static JComboBox comboBoxFigureNumber = new JComboBox();


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
        add(buttonSerialize).setBounds(10,y+58,100,30);
        add(buttonLoad).setBounds(140,y+58,100,30);
        //add(buttonDraw).setBounds(250,70,150,40);

        comboBoxFigureNumber = new JComboBox();
        add(comboBoxFigureNumber).setBounds(270,y+58,100,30);

        addMouseListener(this);
        addMouseMotionListener(this);

        buttonsAction();
    }

    private void buttonsAction(){
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listOfFigure.clear();
                comboBoxFigureNumber.removeAllItems();
                repaint();
                activeFigure = new NonChooseFigure();
            }
        });

        buttonSerialize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fos = new FileOutputStream("E:\\ВЛАД\\4_sem\\oop\\temp.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    int i = 0;
                    for (Figure temp : listOfFigure){
                        oos.writeObject(temp);
                        i++;
                    }
                    oos.flush();
                    oos.close();

                    //write count if figure
                    BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\ВЛАД\\4_sem\\oop\\figureCount.txt"));
                    writer.write(i+"");
                    writer.flush();
                    writer.close();
                }
                catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("E:\\ВЛАД\\4_sem\\oop\\figureCount.txt"));
                    int figureCount = Integer.parseInt(reader.readLine());
                    FileInputStream fis = new FileInputStream("E:\\ВЛАД\\4_sem\\oop\\temp.txt");
                    ObjectInputStream oin = new ObjectInputStream(fis);
                    for (int i = 0; i < figureCount; i++) {
                        comboBoxFigureNumber.addItem("Figure "+ i);
                        listOfFigure.add((Figure)oin.readObject());
                    }
                    repaint();
                }
                catch (Exception ee) {
                    ee.printStackTrace();
                }
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

        //add figure to combo box
        comboBoxFigureNumber.addItem("String " + (listOfFigure.size()-1));
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
