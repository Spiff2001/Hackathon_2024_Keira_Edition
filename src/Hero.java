import java.awt.*;

public class Hero {

    public String name;
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;
    public int lives;
    public Rectangle hitbox;
    public boolean up, down, left, right;



    public Hero (int pXpos, int pYpos){

        xpos = pXpos;
        ypos = pYpos;
        dx = 5;
        dy = 5;
        lives = 4;
        width = 65;
        height = 65;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);
        up = false;
        down = false;
        left = false;
        right = false;


    }

    public void move (){

        if  (up && ypos>500){
            ypos = ypos - dy;
        }

        if (down&&ypos<700-height){
            ypos = ypos + dy;
        }

        if (left&&xpos>0){
            xpos = xpos - dx;
        }

        if (right&&xpos<600-width){
            xpos = xpos + dx;
        }

        hitbox = new Rectangle(xpos, ypos, width, height);

    }

}
