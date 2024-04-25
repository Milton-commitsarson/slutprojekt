import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame
{
    public Points myPoints = new Points();
    public Panel myPanel = new Panel(myPoints);
    public Clock myClock = new Clock();
   // Timer timer;

    public Window() {
        //this.addMouseListener(this);
        this.setBounds(0, 0, 1000, 650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(myPanel);
        this.add(myPoints);
        this.add(myClock);
        this.setVisible(true);
        //timer = new Timer(1000, this);
        //timer.start();

    }

    public Points getMyPoints() {
        return myPoints;
    }

    public Panel getMyPanel() {
        return myPanel;
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {

    }*/
}
