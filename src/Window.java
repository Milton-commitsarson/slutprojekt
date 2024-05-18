import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame implements KeyListener {//skapar JFrame
    static Win myWin = new Win();
    static boolean k = false;
    static Points myPoints = new Points();//skapar nya varsioner av klasserna
    static Clock myClock = new Clock();
    static Panel myPanel = new Panel(myPoints);
    private Menu myMenu = new Menu();
    static boolean lvlCleard = false;

    public Window() {
        this.setBounds(0, 0, 1000, 650);//storlek på JFrame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Stänger ner när krysset klickas
        this.setLayout(null);

        this.addKeyListener(this);//Lägger till tangetklick metoden

        this.add(myMenu);//lägger till menyn
        this.setVisible(true);// gör alltiing snyligt
        this.add(myWin);
        myWin.setVisible(false);

        if (lvlCleard == true) {
            System.out.println("nsfbsfb");
        }

        /*while (k == false) {
            revalidate();
            repaint();
        }*/
    }

    public static boolean awesome = false;

    public static void setAwesome(boolean isAwesome) {

        awesome = isAwesome;

        if (awesome == true) {
            System.out.println("jino");
            k = true;

            System.out.println("non");

            myWin.setVisible(true);

            myPanel.setVisible(false);
            myClock.setVisible(false);
            myPoints.setVisible(false);
            // this.addKeyListener(this);//Lägger till tangetklick metoden

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && myMenu.isVisible()) {// om space tangenten är klickad
            myMenu.setVisible(false);//gömmer menyn
            this.add(myPanel);// visar de andra klasserna
            this.add(myPoints);
            this.add(myClock);
        }
        if (e.getKeyCode() == KeyEvent.VK_R && myWin.isVisible()) {
            myWin.setVisible(false);//gömmer menyn
            myPanel.reset();
            myPanel.setVisible(true);// visar de andra klasserna
            myPoints.reset();
            myPoints.setVisible(true);
            myClock.reset();
            myClock.setVisible(true);
            System.out.println("Nin");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

}
