
import java.awt.*;

public class Enemy1 {
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public int hitCounter = 0;
    public Rectangle hitbox;
    public boolean isAlive;
    public boolean draggedThrough;

    public double currentTime;
    public double respawnTime;
    public double elapsedTime;

    public Image pic;


    public boolean right;
    public boolean down;
    public boolean left;
    public boolean up;


    public Enemy1(int pXpos, int pYpos, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        dx = (int)(Math.random()*10+1);
        dy = (int)(Math.random()*10+1);
        width = 210;
        height = 210;
        pic = picParameter;
        hitbox = new Rectangle(xpos, ypos, width, height);

        }



    public void move(boolean lives) {
//        xpos = xpos - dx;
//        ypos = ypos - dy;

        if(lives == false){
            isAlive=false;
//            hitCounter++;
//            isAlive = true;
            currentTime=System.currentTimeMillis();
            respawnTime=Math.random()*5+3;
            if(currentTime>respawnTime){
                isAlive=true;
            }
        }
        else{
            xpos=xpos+dx;
            if (xpos > 900 - width) {
                xpos = 900-width;
            }

            if ( xpos < 0) {
                xpos=0;
            }
        }
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

}
