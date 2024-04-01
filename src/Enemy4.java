
import java.awt.*;

public class Enemy4 {
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
    public int hitCounter = 0;
    public Rectangle hitbox;
    public boolean isAlive;
    public Image pic;


    public Enemy4(int pXpos, int pYpos, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        width = 250;
        height = 250;
        pic = picParameter;
        hitbox = new Rectangle(xpos, ypos, width, height);
        if(isAlive == false){
            hitCounter++;
            isAlive = true;
        }

    }

}
