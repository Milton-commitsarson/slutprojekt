import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class WrongClicked extends JPanel  { //en Panel i JFrame som håller koll på poängen
        public Window window;
        public int clickTotal = 15;
    public static int clicksLeft = 15;

        public WrongClicked(Window window) {//storlek och placering av rektanglen
            setBounds(230, 570, 10, 10);
            this.setSize(150, 30);
            this.window = window;
        }

        protected void paintComponent(Graphics g) {// ritar ut texten och lådan samt förnyar hela tiden
            super.paintComponent(g);
            setBackground(Color.lightGray);
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("Clicks: "+clicksLeft+ " / " + clickTotal, 10, 20);
            this.revalidate();
            this.repaint();
        }

        public void reset() {
            clicksLeft = clickTotal;
        }
        public void ClickMinus(){
            if(clicksLeft > 1) {
                clicksLeft--;
            }else{
                this.window.setGameOver(true);
            }
    }


}


