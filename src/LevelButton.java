import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class LevelButton extends JButton implements ActionListener {

    public LevelButton(int xPos, int yPos, int width, int height) {
        this.setBackground(Color.black);
        this.setBounds(xPos, yPos, width, height);
    }

    abstract public void buttonWasPressed(ActionEvent e);

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonWasPressed(e);
    }
}
