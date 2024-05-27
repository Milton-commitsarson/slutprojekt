import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame implements KeyListener, MouseListener {//skapar JFrame
    static Win myWin = new Win();
    static Loose myLoose = new Loose();
    static Points myPoints = new Points();//skapar nya varsioner av klasserna
    static Clock myClock = new Clock();

    private Menu myMenu = new Menu();
    //private Level myLevel = new Level();
     WrongClicked myWrongClicked = new WrongClicked(this);
    Panel myPanel = new Panel(myPoints, myWrongClicked);
    Levels myLevels = new Levels();
    static int go;
    Boolean home = false;
    public static boolean awesome = false;
    public boolean gameOver = false;

    public Window() {
        this.setBounds(0, 0, 1000, 650);//storlek på JFrame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//Stänger ner när krysset klickas
        this.setLayout(null);

        this.addKeyListener(this);//Lägger till tangetklick metoden



        this.add(myMenu);//lägger till menyn
        this.add(myLevels);
        this.setVisible(true);// gör alltiing snyligt
        this.add(myWin);
        this.add(myLoose);
        myLoose.setVisible(false);
        myWin.setVisible(false);
        while (go == 0) {
            System.out.println("");
        }
        Start();
    }

    public void setAwesome(boolean isAwesome) {

        awesome = isAwesome;

        if (awesome == true) {
            myWin.setVisible(true);

            myPanel.setVisible(false);
            myClock.setVisible(false);
            myPoints.setVisible(false);
            //myWrongClicked.setVisible(false);

        }
    }

    public void setGameOver(boolean isGameOver) {

        gameOver = isGameOver;
        if (gameOver == true) {
            myLoose.setVisible(true);

            myPanel.setVisible(false);
            myClock.setVisible(false);
            myPoints.setVisible(false);
            myWrongClicked.setVisible(false);


        }
    }

    public void Start() {

        myMenu.setVisible(false);//gömmer menyn
        myLevels.setVisible(false);

        this.add(myPanel);// visar de andra klasserna
        this.add(myPoints);
        this.add(myClock);
        this.add(myWrongClicked);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && myMenu.isVisible()) {// om space tangenten är klickad
            myMenu.setVisible(false);//gömmer menyn
            myLevels.setVisible(false);
            this.add(myPanel);// visar de andra klasserna
            this.add(myPoints);
            this.add(myClock);
            this.add(myWrongClicked);
            go = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_R && myWin.isVisible() || e.getKeyCode() == KeyEvent.VK_R && myLoose.isVisible()) {
            myWin.setVisible(false);//gömmer menyn
            myLoose.setVisible(false);
            myPanel.reset();
            myPanel.setVisible(true);// visar de andra klasserna
            myPoints.reset();
            myPoints.setVisible(true);
            myClock.reset();
            myClock.setVisible(true);
            myWrongClicked.reset();
            myWrongClicked.setVisible(true);
            System.out.println("Nin");
            go = 0;

        }
        if (e.getKeyCode() == KeyEvent.VK_R) {// om space tangenten är klickad
            myLoose.setVisible(false);
            myMenu.setVisible(true);//gömmer menyn
            myLevels.setVisible(false);
            this.add(myPanel);// visar de andra klasserna
            this.add(myPoints);
            this.add(myClock);
            this.add(myWrongClicked);
            //go = 1;
            setGameOver(true);
        }
        /*if (e.getKeyCode() == KeyEvent.VK_M && myLoose.isVisible()) {
            myWin.setVisible(false);//gömmer menyn
            myLoose.setVisible(false);
            myPanel.reset();
            myPanel.setVisible(true);// visar de andra klasserna
            myPoints.reset();
            myPoints.setVisible(true);
            myClock.reset();
            myClock.setVisible(true);
            myWrongClicked.reset();
            myWrongClicked.setVisible(true);
            System.out.println("Nin");
            //go = 0;

        }*/

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
