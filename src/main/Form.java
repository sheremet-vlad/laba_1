package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    int x1 = 300,x2 = 300, x3 = 50,x4= 10;
    public Graphics g1 = this.getGraphics();
    private ButtonGroup  typeFigure = new ButtonGroup();

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
        add(buttonDraw).setBounds(250,70,150,40);

        //метод с дейтвиями комп-в
        actionComponent();

    }

    public void actionComponent(){
        buttonDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x1=400; x2 = 400; x3 = 150; x4 = 5;
                repaint();
            }
        });
    }

    /*class Board extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            // super.paintComponents(g);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(100, 250, 200, 200);
        }
    }*/


    public void paint(Graphics g) {
       // g1 = g;
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawLine(300,300,50,10);
        Figure fig = new Circle();
        fig.paintFigure(g);
    }
}
