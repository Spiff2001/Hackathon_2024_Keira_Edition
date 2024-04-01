
import java.awt.*;

public class Enemy {
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

    public Enemy(int pXpos, int pYpos) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        width = 65;
        height = 65;
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
