
import javax.swing.*;
import java.awt.*;

public class MyObject extends JPanel {

    int xPos;
    int yPos;

   // int size;

    public MyObject(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        //this.size = size;
        this.setBackground(Color.pink);
        this.setSize(60,60);
        this.setVisible(true);

    }


/*
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.setColor(Color.blue);
            g.drawRect(0,0,40,49);
            System.out.println("d");

        }

 */
}
