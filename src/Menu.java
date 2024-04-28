import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel { //JPanel som är start skärmen i Jframe

    public Menu() {// plasering och storlek av menyn
        setBounds(0, 0, 10, 10);
        this.setSize(1000, 650);
    }

    protected void paintComponent(Graphics g) {// det som uppstår nör man startar spelet och instruktioner
        super.paintComponent(g);
        setBackground(Color.yellow);
        g.setFont(Font.getFont("Ariel"));
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("THE MISSING PARTS GAME", 350, 200);
        g.drawString("Instructions:", 400, 250);
        g.drawString("Find every missing part om the right picture", 300, 270);
        g.drawString("in the least time as possible.", 300, 290);
        g.drawString("To find the missing parts, click with your mouse-pad", 300, 330);
        g.drawString("Good luck!!!", 400, 360);

        g.drawString("Press SPACE to start", 380, 400);

    }

}
