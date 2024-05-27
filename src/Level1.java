import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Level1 extends Level {
    public Level1() {
        this.setBounds(0,0,1000, 650);
        this.setSize(1000, 650);//storlek

    }
    public  void show(){
        this.setBackground(Color.blue);
        this.setVisible(true);
        System.out.println("level1 show");
        repaint();
        revalidate();
    }

    @Override
    void generateHiddenobjects() {
        this.hiddenObjects.add(new HiddenObject(582, 433));// Alla gömda föremål och dess kordinater
        this.hiddenObjects.add(new HiddenObject(702, 529));
        this.hiddenObjects.add(new HiddenObject(763, 156));
        this.hiddenObjects.add(new HiddenObject(663, 357));
        this.hiddenObjects.add(new HiddenObject(847, 443));
        this.hiddenObjects.add(new HiddenObject(907, 363));
        System.out.println("jsfsfsefsef");
    }

    public void addHiddenobjects(){
        for (HiddenObject object: this.hiddenObjects){
            this.add(object);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(Levels.myImage.getFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image, 0, 0, 1000, 550, this);//Ritat ut bilden
        repaint();
    }
}
