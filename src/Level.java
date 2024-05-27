import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Level  extends JPanel {
   public ArrayList<HiddenObject> hiddenObjects = new ArrayList<>();
    public Level(){

    }
    abstract void generateHiddenobjects();



}
