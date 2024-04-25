import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {
    private myImage myImage = new myImage("DubbelRiktig1-1.png");
    private Points myPoints;

    //ArrayList<MyObject> ObjList = new ArrayList<>();
    ArrayList<HiddenObject> hiddenObjects = new ArrayList<>();
    ArrayList<HiddenObject> foundObjects = new ArrayList<>();


    public Panel(Points myPoints) {
        this.myPoints = myPoints;
        this.addMouseListener(this);
        this.setBackground(Color.BLACK);
        this.setSize(1000, 1000);


        this.setVisible(true);

        hiddenObjects.add(new HiddenObject(582, 433));
        hiddenObjects.add(new HiddenObject(702, 529));
        hiddenObjects.add(new HiddenObject(763, 156));
        hiddenObjects.add(new HiddenObject(663, 357));
        hiddenObjects.add(new HiddenObject(847, 443));

        myPoints.objTotal = hiddenObjects.size();
        myPoints.objFound = myPoints.objTotal;

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File(myImage.getFilename()));
            System.out.println("red");
            g.drawImage(image, 0, 0, 1000, 550, this);
            //g.drawImage(image, 0, 0, this);
        } catch (IOException e) {
            System.out.println("error");
        }

        for (HiddenObject hidObj : hiddenObjects) {
            if (!hidObj.isHidden) {
                g.setColor(Color.red);
                g.drawRect(hidObj.xPos - hidObj.width / 2, hidObj.yPos - hidObj.height / 2, hidObj.width, hidObj.height);
            }

        }
        //System.out.println(ObjList);
        /*for (MyObject things : ObjList) {
            g.setColor(Color.green);
           // g.drawRect(things.xPos - 30, things.yPos - 30, 30, 30);
        }*/

    }

    public myImage getMyImage() {
        return myImage;
    }

    public void setImage(myImage myImage) {
        this.myImage = myImage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //ObjList.add(new MyObject(e.getX(), e.getY()));
        for (HiddenObject obj : hiddenObjects) {
            if (obj.xPos - obj.getWidth() / 2 < e.getX() &&
                    obj.xPos + obj.getWidth() / 2 > e.getX() &&
                    obj.yPos - obj.getWidth() / 2 < e.getY() &&
                    obj.yPos + obj.getHeight() / 2 > e.getY()) {
                if (obj.isHidden) {
                    obj.isHidden = false;
                    myPoints.objFound--;
                }
            }
        }
        System.out.println(e.getX() + " , " + e.getY());
        this.revalidate();
        this.repaint();
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
