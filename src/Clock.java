import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JPanel implements ActionListener {

    public int minute = 0;//minutvisare
    public int seconds= 0;//sekundvisare
    Timer timer;//skapar en ny timer

    public Clock() {
        setBounds(900, 570, 70, 30);//rutans placering
        this.setSize(70, 30);//storlek på rutan
        timer = new Timer(1000, this);// sätter en ny klocka som tickar efter 1000 millisekunder
        timer.start();
    }

    protected void paintComponent(Graphics g) {//Ritar ut allting
        super.paintComponent(g);
        setBackground(Color.yellow);//bakrundsfärg
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); // font och storlek
        //return Points(objTotal)
        if (seconds > 9){// gör så att det är en nolla framför sekund räknaren tills att det har gått 10 sekunder
            g.drawString( minute+ " : " +seconds, 10, 20);
        }else {
            g.drawString(  minute+ " : " + 0 +seconds, 10, 20);
        }
        this.revalidate();//förnyar
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {//
        seconds++;//att klcokan ökas
        if (seconds == 60){// att sekundvisaren nollställs efter 60 sekunder och att minutvisaren ökas
            seconds = 0;
            minute++;
        }
    }
}
