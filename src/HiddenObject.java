import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HiddenObject extends MyObject implements MouseListener {

    protected boolean isHidden = true;// att objekten är gömda

    public HiddenObject(int xPos, int yPos) {//koordinaterna av objekten
        super(xPos, yPos);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("this was clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
