
import java.awt.*;

public class Enemy1 {
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
    public int hitCounter = 0;
    public Rectangle hitbox;
    public boolean isAlive;

    public double currentTime;
    public double respawnTime;
    public double elapsedTime;

    public Image pic;



    public Enemy1(int pXpos, int pYpos, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        width = 250;
        height = 250;
        pic = picParameter;
        hitbox = new Rectangle(xpos, ypos, width, height);

        }

        public void live(boolean lives){
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

        }

}
