import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame implements KeyListener {//skapar JFrame
    private final Menu myMenu = new Menu();
   // public Win myWin = new Win();



    public Window() {
        this.setBounds(0, 0, 1000, 650);//storlek på JFrame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Stänger ner när krysset klickas
        this.setLayout(null);
        this.add(myMenu);//lägger till menyn
        this.addKeyListener(this);//Lägger till tangetklick metoden
        this.setVisible(true);// gör alltiing snyligt
       /* if(myPoints{
            //  this.add(myWin);
            System.out.println("bbd");
        }*/

       //Points.clear;
       //if (myPoints.clear == false){
        //System.out.println("jgionfiosnfoisn");
       //}

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Points myPoints = new Points();//skapar nya varsioner av klasserna
        Panel myPanel = new Panel(myPoints);
        Clock myClock = new Clock();
        if (e.getKeyCode() == KeyEvent.VK_SPACE){// om space tangenten är klickad
            myMenu.setVisible(false);//gömmer menyn
            this.add(myPanel);// visar de andra klasserna
            this.add(myPoints);
            this.add(myClock);
        }
    }
}
