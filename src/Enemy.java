import java.awt.*;

public class Enemy {
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
    public int hitCounter = 0;
    public Rectangle hitbox;
    public boolean isAlive;



    public Enemy(int pXpos, int pYpos) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        width = 65;
        height = 65;
        hitbox = new Rectangle(xpos, ypos, width, height);
        if(isAlive == false){
            hitCounter++;
            isAlive = true;
        }

    }

}
