import javax.swing.*;
import java.awt.*;


public class Points extends JPanel { //en Panel i JFrame som håller koll på poängen
    public int objFound;
    public int objTotal;
    // static JLabel score;
    public static boolean clear = false;



    public Points() {//storlek och placering av rektanglen
        setBounds(10, 570, 10, 10);
        this.setSize(70, 30);
    }

    protected void paintComponent(Graphics g) {// ritar ut texten och lådan samt förnyar hela tiden
        super.paintComponent(g);
        setBackground(Color.yellow);
        //return Points(objTotal);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(objFound + " / " + objTotal, 10, 20);
        this.revalidate();
        this.repaint();

        if (objFound== 5){
            clear = true;
            //System.out.println("f");
        }
        //g.drawRect(0, 0, 10, 10);

    }
}
