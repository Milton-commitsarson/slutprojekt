import javax.swing.*;
import java.awt.*;

public class MyObject extends JPanel {//skapandet av tomma kordinater och stolek på hitbox
    int xPos;
    int yPos;
    int width = 50;
    int height = 50;

    public MyObject(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.setSize(60, 60);
    }
}
