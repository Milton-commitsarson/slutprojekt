import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JPanel implements ActionListener {

    public int minute = 0;
    public int seconds= 0;
    public int zero = 0;
    Timer timer;
    // static JLabel score;

    public Clock() {
        setBounds(110, 590, 10, 10);
        this.setSize(100, 15);
        this.setVisible(true);
        //score = new JLabel(objFound +"/" + objTotal);
        //Points.add(score);
        timer = new Timer(1000, this);
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.CYAN);
        g.setFont(Font.getFont("Ariel"));
        //return Points(objTotal)
        if (seconds > 9){
            g.drawString(zero + minute+ " : " +seconds, 10, 10);
        }else {
            g.drawString(zero + minute+ " : " + zero +seconds, 10, 10);
        }
        this.revalidate();
        this.repaint();


        //g.drawRect(0, 0, 10, 10);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seconds++;
        if (seconds == 60){
            seconds = 0;
            minute++;
        }
    }
}
