import javax.swing.*;
import java.awt.*;


public class Win extends JPanel  { //en JPannel i Jframe som uppstår när man hittat allt


    public Win() {
        setBounds(0, 0, 10, 10);//placering
        this.setSize(1000, 650);//storlek
    }

    protected void paintComponent(Graphics g) {// text som uppstår när man hittat alla object
        super.paintComponent(g);
        setBackground(Color.CYAN);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));//Font och storlek
        g.drawString("You won", 350, 200);//text
        g.drawString("Your time:", 400, 250);
        g.drawString("Press R to Replay", 300, 290);


    }


}
