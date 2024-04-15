import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {


    public Window() {
        //this.addMouseListener(this);
        this.setBounds(0, 0, 800, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(new Panel());
        this.setVisible(true);
        //this.add(new MyObject(100,10));
    }
}
