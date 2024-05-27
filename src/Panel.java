import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {
    private WrongClicked wrongClicked;
    private final Points myPoints;// skapar klassen points i Panel
    //ArrayList<HiddenObject> hiddenObjects = new ArrayList<>();//listan som inehåller alla gömda obejkt
    private ArrayList<HiddenObject> hiddenObjects;
    private Levels  levels = new Levels();





    public Panel(Points myPoints, WrongClicked wrongClicked) {

        this.myPoints = myPoints;
        this.addMouseListener(this);
       // this.setBackground(Color.BLACK);
        this.setSize(1000, 550);//storlek på Panelen
        this.hiddenObjects = new ArrayList<>();
       // this.hiddenObjects = levels.getHiddenObjects();
            pickLevel();
        this.wrongClicked = wrongClicked;

        myPoints.objTotal = hiddenObjects.size();//antalet objekt
        myPoints.objLeft = myPoints.objTotal;


    }
 public void pickLevel(){

         this.hiddenObjects = levels.getHiddenObjects();



         this.hiddenObjects = levels.getHiddenObjects2();




 }

    /*public void setLevels(Levels levels) {
        this.levels = levels;
    }*/
    protected void paintComponent(Graphics g) {
        //Levels.pic() ;
        super.paintComponent(g);
        //BufferedImage image;

        try {
            if(Levels.whichLevel== 1) {
                BufferedImage image = ImageIO.read(new File(Levels.myImage.getFilename()));
                g.drawImage(image, 0, 0, 1000, 550, this);//Ritat ut bilden
                repaint();
            }else if (Levels.whichLevel == 2){
                BufferedImage image = ImageIO.read(new File(Levels.myImage2.getFilename()));
                g.drawImage(image, 0, 0, 1000, 550, this);//Ritat ut bilden
                repaint();
            }
        } catch (IOException e) {
            System.out.println("error");// ifall det inte går att rita ut bilden
        }

        for (HiddenObject hidObj : hiddenObjects) { //ritar ut lådan på objekten när det blivit hittade
            if (!hidObj.isHidden) {//om hittade
                g.setColor(Color.red);//färg på låda
                g.drawRect(hidObj.xPos - hidObj.width / 2, hidObj.yPos - hidObj.height / 2, hidObj.width, hidObj.height);//ritar låda på höger sida
                g.drawRect(hidObj.xPos - hidObj.width / 2 -492, hidObj.yPos - hidObj.height / 2, hidObj.width, hidObj.height);//låda på vänster sida

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wrongClicked.ClickMinus();
        boolean foundObject = false;
        for (HiddenObject obj : hiddenObjects) {// kontrolerar ifall musen klickar inom korrdinaterna av lådan till ett gömt objekt, både på vänstra och höger bild
            if (obj.xPos - obj.getWidth() / 2 < e.getX() &&
                    obj.xPos + obj.getWidth() / 2 > e.getX() &&
                    obj.yPos - obj.getWidth() / 2 < e.getY() &&
                    obj.yPos + obj.getHeight() / 2 > e.getY() || obj.xPos - obj.getWidth() / 2 - 492  < e.getX() &&
                    obj.xPos + obj.getWidth() / 2 - 492> e.getX()  &&
                    obj.yPos - obj.getWidth() / 2 < e.getY() &&
                    obj.yPos + obj.getHeight() / 2 > e.getY() ) {
                if (obj.isHidden) {
                    obj.isHidden = false;
                    foundObject = true;
                    myPoints.objLeft--;// ifall objektet blir hittat så minskar detta antalet av de hittade obejekten

                }
            }
        }

        if(!foundObject){
            System.out.println("You clicked wrong loooser");


        }
        if(myPoints.objLeft == 1){
            wrongClicked.window.setAwesome(true);
        }
        //System.out.println(e.getX() + " , " + e.getY());// skriver ut koordinaterna
        this.revalidate();//förnyar
        this.repaint();



    }

    public void reset(){
        myPoints.objLeft = myPoints.objTotal;

        for (HiddenObject hiddenObject : hiddenObjects) {
            hiddenObject.isHidden = true;
        }
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
