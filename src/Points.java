import javax.swing.*;
import java.awt.*;


public class Points extends JPanel {
    public int objFound;
    public int objTotal;
    // static JLabel score;

    public Points() {
        setBounds(10, 590, 10, 10);
        this.setSize(100, 15);
        this.setVisible(true);
        //score = new JLabel(objFound +"/" + objTotal);
        //Points.add(score);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.CYAN);
        g.setFont(Font.getFont("Ariel"));
        //return Points(objTotal);
        g.drawString(objFound + " / " + objTotal, 10, 10);
        this.revalidate();
        this.repaint();

        //g.drawRect(0, 0, 10, 10);

    }
}
