import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {
    private final myImage myImage = new myImage("DubbelRiktig1-1.png");//Hämtar bilden
    private final Points myPoints;// skapar klassen points i Panel

    ArrayList<HiddenObject> hiddenObjects = new ArrayList<>();//listan som inehåller alla gömda obejkt




    public Panel(Points myPoints) {
        this.myPoints = myPoints;
        this.addMouseListener(this);
        this.setBackground(Color.BLACK);
        this.setSize(1000, 1000);//storlek på Panelen


        this.setVisible(true);

        hiddenObjects.add(new HiddenObject(582, 433));// Alla gömda föremål och dess kordinater
        hiddenObjects.add(new HiddenObject(702, 529));
        hiddenObjects.add(new HiddenObject(763, 156));
        hiddenObjects.add(new HiddenObject(663, 357));
        hiddenObjects.add(new HiddenObject(847, 443));
        hiddenObjects.add(new HiddenObject(907 , 363));

        myPoints.objTotal = hiddenObjects.size();//antalet objekt
        myPoints.objFound = myPoints.objTotal;
        System.out.println(myPoints.objFound);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File(myImage.getFilename()));// läser in bilden
            g.drawImage(image, 0, 0, 1000, 550, this);//Ritat ut bilden
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
    public Win myWin = new Win();

    @Override
    public void mouseClicked(MouseEvent e) {
        //ObjList.add(new MyObject(e.getX(), e.getY()));
        for (HiddenObject obj : hiddenObjects) {// kontrolerar ifall musen klickar inom korrdinaterna av lådan till ett gömt objekt, både på vänstra och höger bild
            if (obj.xPos - obj.getWidth() / 2 < e.getX() &&
                    obj.xPos + obj.getWidth() / 2 > e.getX() &&
                    obj.yPos - obj.getWidth() / 2 < e.getY() &&
                    obj.yPos + obj.getHeight() / 2 > e.getY() || obj.xPos - obj.getWidth() / 2 - 492  < e.getX() &&
                    obj.xPos + obj.getWidth() / 2 - 492> e.getX() &&
                    obj.yPos - obj.getWidth() / 2 < e.getY() &&
                    obj.yPos + obj.getHeight() / 2 > e.getY()  ) {
                if (obj.isHidden) {
                    obj.isHidden = false;
                    myPoints.objFound--;// ifall objektet blir hittat så minskar detta antalet av de hittade obejekten

                }
            }
        }
        System.out.println(e.getX() + " , " + e.getY());// skriver ut koordinaterna
        this.revalidate();//förnyar
        this.repaint();
        if (myPoints.objFound == 4){
            this.add(myWin);
            this.setVisible(true);
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
