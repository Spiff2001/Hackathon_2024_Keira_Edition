
import java.awt.*;

public class Enemy2 {
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
    public int lifeCounter;



    public Enemy2(int pXpos, int pYpos, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        isAlive = true;
        dy = (int)(Math.random()*8+2);
        dx = (int)(Math.random()*10-5);
        width = 210;
        height = 210;
        pic = picParameter;
        hitbox = new Rectangle(xpos, ypos, width, height);
        picPicker = (int)(Math.random()*3)+1;
        gravity=2;

    }



    public void move() {

//        xpos = xpos - dx;
//        ypos = ypos - dy;
        counter+=1;
        if(!isAlive){
            dy=0;
            lifeCounter+=1;
            if(lifeCounter%(int)(Math.random()*500)==0){
                isAlive=true;
                xpos=900;
                ypos=(int)(Math.random()*300);
                dx = (int)(Math.random()*8-2);
                dy = (int)(Math.random()*8+2);
            }
        }
        else{
            xpos=xpos+dx;
            ypos=ypos-dy;
            if((counter%20)==0){
                dy=dy-gravity;
            }

            if(ypos>675&isAlive==true){
                ypos=(int)(Math.random()*300);
                dy = (int)(Math.random()*2+4);;
            }
            if((xpos>1000)&isAlive==true){
                xpos=0;
                dx = (int)(Math.random()*6+2);

            }



        }
        hitbox = new Rectangle(xpos,ypos,width,height);
    }

}
