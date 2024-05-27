// Levels.java

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Levels extends JPanel implements ActionListener {


    // final myImage myImage = new myImage("beach-7732259_1280.jpg");//Hämtar bilden
    //private myImage myImage;
    private ArrayList<HiddenObject> hiddenObjects = new ArrayList<>();
    private ArrayList<HiddenObject> hiddenObjects2 = new ArrayList<>();
    JButton level1 = new JButton("1");
    JButton level2 = new JButton("2");
    public Level1 level1Screen = new Level1();
    public static int whichLevel;


    // Level1Button level1Knapp = new Level1Button(100, 300, 200, 100);
    //  ArrayList<HiddenObject> level1HiddenObjects = new ArrayList<>();

    public Levels() {
        setBounds(10, 500, 300, 10);
        this.setSize(300, 100);
        //this.add(level1Knapp);
        // this.myImage = myImage;
        this.add(level1Screen);

        addHiddenObjects();
        addHiddenObjects2();
        revalidate();
        repaint();

    }

    static final myImage myImage = new myImage("Level2.png");//Hämtar bilden
    static final myImage myImage2 = new myImage("Level2.png");//Hämtar bilden

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        level1.setBounds(0, 0, 100, 30);
        add(level1);
        level1.addActionListener(this);
        level2.setBounds(150, 0, 100, 30);
        add(level2);
        level2.addActionListener(this);
        setBackground(Color.yellow);


    }

    public void stall() throws InterruptedException {
        wait();
    }

    public void addHiddenObjects() {

        hiddenObjects.add(new HiddenObject(582, 433));// Alla gömda föremål och dess kordinater
        hiddenObjects.add(new HiddenObject(702, 529));
        hiddenObjects.add(new HiddenObject(763, 156));
        hiddenObjects.add(new HiddenObject(663, 357));
        hiddenObjects.add(new HiddenObject(847, 443));
        hiddenObjects.add(new HiddenObject(907, 363));
    }

    public void addHiddenObjects2() {

        hiddenObjects.add(new HiddenObject(10, 10));
        hiddenObjects.add(new HiddenObject(10, 10));
        hiddenObjects.add(new HiddenObject(10, 10));
        hiddenObjects.add(new HiddenObject(10, 10));
    }


    public void addLevel1Objects() {
        hiddenObjects.add(new HiddenObject(702, 529));
        hiddenObjects.add(new HiddenObject(763, 156));
        hiddenObjects.add(new HiddenObject(663, 357));
        hiddenObjects.add(new HiddenObject(847, 443));
        hiddenObjects.add(new HiddenObject(907, 363));
        hiddenObjects.add(new HiddenObject(907, 363));
        hiddenObjects.add(new HiddenObject(907, 363));
    }

    public ArrayList<HiddenObject> getHiddenObjects() {
        if (whichLevel == 1) {
            return hiddenObjects;
        }
        return new ArrayList<HiddenObject>();
    }

    public ArrayList<HiddenObject> getHiddenObjects2() {
        if (whichLevel == 2) {
            return hiddenObjects;
        }
        return new ArrayList<HiddenObject>();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedLevel = (JButton) e.getSource();
        if (clickedLevel.equals(level1)) {
           whichLevel = 1;
            this.level1Screen.show();

            addHiddenObjects();
            Window.go = 1;

            revalidate();
            repaint();
            disableButtons();
        } else if (clickedLevel.equals(level2)) {
            System.out.println("lvl2");
            whichLevel = 2;
            disableButtons();
            addHiddenObjects2();
            repaint();

        }

        System.out.println("Jjnj0oj");
    }


    private void disableButtons() {
        level1.setEnabled(false);
        level2.setEnabled(false);

    }


}