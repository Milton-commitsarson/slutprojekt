import javax.swing.*;
import java.awt.*;

public class MyObject extends JPanel {//skapandet av tomma kordinater och stolek på hitbox
    protected int xPos;
    protected int yPos;
    protected int width = 50;
    protected int height = 50;

    public MyObject(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.setSize(60, 60);
    }
}
