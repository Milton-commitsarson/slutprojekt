import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loose extends JPanel implements ActionListener {
    JButton menuButton = new JButton("Go to menu");
    public Loose() {
        setBounds(0, 0, 10, 10);//placering
        this.setSize(1000, 650);//storlek

    }

    protected void paintComponent(Graphics g) {// text som uppstår när man hittat alla object
        super.paintComponent(g);
        setBackground(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));//Font och storlek
        g.drawString("You Lost", 350, 200);//text
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));//Font och storlek
        g.drawString("You clicked to many times" , 400, 250);
        g.drawString("Press R to Replay", 300, 290);
        g.drawString("Press m to go to Menu", 300, 320);

        menuButton.setBounds(100, 300, 100, 30);
        add(menuButton);
        menuButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton ClickedButton = (JButton) e.getSource();
        if (ClickedButton.equals(menuButton)){
            Window.j = 0;
        }
    }
}
