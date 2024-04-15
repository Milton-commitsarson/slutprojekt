
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
    private BufferedImage image;

    ArrayList<MyObject> ObjList = new ArrayList<>();

    public Panel() {
        this.addMouseListener(this);
        this.setBackground(Color.BLACK);
        this.setSize(800,500);
        /*try{
            image= ImageIO.read(new File("image.png"));
            System.out.println("red");
        } catch (IOException e) {
            System.out.println("error");
        }*/
        this.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
        //System.out.println(ObjList);
        for (MyObject things: ObjList) {
            g.setColor(Color.green);
            g.drawRect(things.xPos - 30, things.yPos - 30, 30, 30);
        }

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        ObjList.add(new MyObject(e.getX(), e.getY()));
        //System.out.println(e.getX() + " | " + e.getY());
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
