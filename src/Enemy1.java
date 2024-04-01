
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
    public int counter;

    public Image pic;

    public int picPicker;
    public int gravity;



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
        picPicker = (int)(Math.random()*3)+1;
        gravity=2;

    }



    public void move(boolean lives) {

//        xpos = xpos - dx;
//        ypos = ypos - dy;
        counter+=1;
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
            ypos=ypos-dy;

            if((counter%20)==0){
                dy=dy-gravity;
            }

            if (xpos > 900 - width) {
                xpos = 900-width;
            }

            if ( xpos < 0) {

            }

        }
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

}