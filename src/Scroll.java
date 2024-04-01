import java.awt.*;
import java.awt.Image;
import java.awt.Toolkit;

public class Scroll{
    public Image backgroundPic1;
    public Image backgroundPic2;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;

    public Scroll (int pYpos, int pXpos) {
        xpos = pXpos;
        ypos = pYpos;
        dy = 5;
    }

    public void move() {
        ypos = ypos + dy;
    }

    public void wrap() {
        ypos = ypos + dy;

        if (ypos >= 700) {
            ypos = -700;
        }
    }

}
