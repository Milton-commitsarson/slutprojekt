import java.awt.*;

public class HiddenObject extends MyObject{

    boolean isHidden = true;// att objekten är gömda

    public HiddenObject(int xPos, int yPos) {//koordinaterna av objekten
        super(xPos, yPos);
    }
}
