//Basic Game Application
// Basic Object, Image, Movement
// Threaded

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;


//*******************************************************************************

public class BasicGameApp implements Runnable, MouseListener, MouseMotionListener, KeyListener {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 900;
    final int HEIGHT = 675;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public Image background;
    public Image background2;
    public Image background3;
    public Image background4;
    public Image background5;
    public Image background6;
    public Image background7;
    public Image enemy1IMG;
    public Image enemy2IMG;
    public Image enemy3IMG;
    public Image enemy4IMG;
    public Image killSplotch;
    public Image killSplotch2;
    public Image killSplotch3;
    public Image gameOverImage;
    public boolean gameOver;

    public BufferStrategy bufferStrategy;

    public Enemy1 enemies1[];
    public Enemy2 enemies2[];
    public Enemy3 enemies3[];

    public int killCount = 0;

    public int mouseX, mouseY;
    public int mousePressedX, mousePressedY;
    public int mouseReleasedX, mouseReleasedY;

//    public int picPicker;

    public boolean dragging = false;




    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor


        setUpGraphics();
        gameOver=false;
        gameOverImage=Toolkit.getDefaultToolkit().getImage("game over.jpg");
        background = Toolkit.getDefaultToolkit().getImage("background game.jpg");
        background2 = Toolkit.getDefaultToolkit().getImage("background game 2.jpg");
        background3 = Toolkit.getDefaultToolkit().getImage("background game 3.jpg");
        background4 = Toolkit.getDefaultToolkit().getImage("background game 4.jpg");
        background5 = Toolkit.getDefaultToolkit().getImage("background game 5.jpg");
        background6 = Toolkit.getDefaultToolkit().getImage("background game 6.jpg");
        background7 = Toolkit.getDefaultToolkit().getImage("background game 7.jpg");
        enemy1IMG = Toolkit.getDefaultToolkit().getImage("enemies 1.png");
        enemy2IMG = Toolkit.getDefaultToolkit().getImage("enemies 2.png");
        enemy3IMG = Toolkit.getDefaultToolkit().getImage("enemies axolotl.png");
        enemy4IMG = Toolkit.getDefaultToolkit().getImage("enemies snitch.png");
        killSplotch = Toolkit.getDefaultToolkit().getImage("splatter 1.png");
        killSplotch2 = Toolkit.getDefaultToolkit().getImage("splatter 2.png");
        killSplotch3 = Toolkit.getDefaultToolkit().getImage("splatter 3.png");

        enemies1 = new Enemy1[6];
        enemies2 = new Enemy2[3];
        enemies3 = new Enemy3[3];
        for(int i = 0; i < enemies1.length; i++){

            enemies1[i] = new Enemy1(i*10+20,400, enemy1IMG);
        }
        for(int i = 0; i < enemies2.length; i++){
            enemies2[i] = new Enemy2(0,200, enemy2IMG);
            enemies3[i] = new Enemy3(0,200, enemy3IMG);
        }

        //variable and objects
        //create (construct) the objects needed for the game

    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    public void checkIntersections() {
        for (int i = 0; i < enemies1.length; i++) {
            if(enemies1[i].hitbox.contains(mouseX,mouseY)){
                if (Math.sqrt((mousePressedX-mouseX)*(mousePressedX-mouseX)+(mousePressedY-mouseY)*(mousePressedY-mouseY)) >= enemies1[i].width*0.75) {
                    if (enemies1[i].isAlive == true) {
                        killCount++;
                    }
                    enemies1[i].isAlive=false;
                    enemies1[i].dx = 0;
                    enemies1[i].dy = 0;
                    enemies1[i].gravity = 0;
                } else {
                    System.out.println("Attack too short");
                }
            }
        }

        for (int i = 0; i < enemies2.length; i++) {
            if(enemies2[i].hitbox.contains(mouseX,mouseY)){
                if(enemies2[i].hitbox.contains(mouseX,mouseY)){
                    if (Math.sqrt((mousePressedX-mouseX)*(mousePressedX-mouseX)+(mousePressedY-mouseY)*(mousePressedY-mouseY)) >= enemies2[i].width*0.75) {
                        if (enemies2[i].isAlive == true) {
                            killCount++;
                        }
                        enemies2[i].isAlive=false;
                        enemies2[i].dx = 0;
                        enemies2[i].dy = 0;
                        enemies2[i].gravity = 0;
                    } else {
                        System.out.println("Attack too short");
                    }
                }
            }
            if(enemies3[i].hitbox.contains(mouseX,mouseY)){
                if(enemies3[i].hitbox.contains(mouseX,mouseY)){
                    if (Math.sqrt((mousePressedX-mouseX)*(mousePressedX-mouseX)+(mousePressedY-mouseY)*(mousePressedY-mouseY)) >= enemies3[i].width*0.75) {
                        if (enemies3[i].isAlive == true) {

                        }
                        gameOver=true;

                    } else {
                        System.out.println("Attack too short");
                    }
                }
            }
        }
        
    }

    public void moveThings() {
        for (int i = 0; i < enemies1.length; i++) {
            enemies1[i].move();
        }

        for (int i = 0; i < enemies2.length; i++) {
            enemies2[i].move();
            enemies3[i].move();
        }
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g.drawString("Score " + killCount*100, 40, 40);
        if(gameOver){
            g.drawImage(gameOverImage, 0, 0, WIDTH, HEIGHT, null);
        }
        else {
            //draw the images
            for (int i = 0; i < enemies1.length; i++) {
                if (enemies1[i].isAlive == true) {
                    g.drawImage(enemies1[i].pic, enemies1[i].xpos, enemies1[i].ypos, enemies1[i].width, enemies1[i].height, null);
                } else if (enemies1[i].isAlive == false) {
                    int picPicker = enemies1[i].picPicker;
                    if (picPicker == 1) {
                        g.drawImage(killSplotch, enemies1[i].xpos, enemies1[i].ypos, enemies1[i].width, enemies1[i].height, null);
                    } else if (picPicker == 2) {
                        g.drawImage(killSplotch2, enemies1[i].xpos, enemies1[i].ypos, enemies1[i].width, enemies1[i].height, null);
                    } else if (picPicker == 3) {
                        g.drawImage(killSplotch3, enemies1[i].xpos, enemies1[i].ypos, enemies1[i].width, enemies1[i].height, null);
                    }
                }
            }
            for (int i = 0; i < enemies2.length; i++) {
                if (enemies2[i].isAlive == true) {
                    g.drawImage(enemies2[i].pic, enemies2[i].xpos, enemies2[i].ypos, enemies2[i].width, enemies2[i].height, null);
                } else if (enemies2[i].isAlive == false) {
                    int picPicker = enemies2[i].picPicker;
                    if (picPicker == 1) {
                        g.drawImage(killSplotch, enemies2[i].xpos, enemies2[i].ypos, enemies2[i].width, enemies2[i].height, null);
                    } else if (picPicker == 2) {
                        g.drawImage(killSplotch2, enemies2[i].xpos, enemies2[i].ypos, enemies2[i].width, enemies2[i].height, null);
                    } else if (picPicker == 3) {
                        g.drawImage(killSplotch3, enemies2[i].xpos, enemies2[i].ypos, enemies2[i].width, enemies2[i].height, null);
                    }
                }
                if (enemies3[i].isAlive == true) {
                    g.drawImage(enemies3[i].pic, enemies3[i].xpos, enemies3[i].ypos, enemies3[i].width, enemies3[i].height, null);
                } else if (enemies3[i].isAlive == false) {
                    int picPicker = enemies3[i].picPicker;
                    if (picPicker == 1) {
                        g.drawImage(killSplotch, enemies3[i].xpos, enemies3[i].ypos, enemies3[i].width, enemies3[i].height, null);
                    } else if (picPicker == 2) {
                        g.drawImage(killSplotch2, enemies3[i].xpos, enemies3[i].ypos, enemies3[i].width, enemies3[i].height, null);
                    } else if (picPicker == 3) {
                        g.drawImage(killSplotch3, enemies3[i].xpos, enemies3[i].ypos, enemies3[i].width, enemies3[i].height, null);
                    }
                }
            }
//    }

        }
        g.dispose();
        bufferStrategy.show();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x, y;
        x = e.getX();
        y = e.getY();

        mousePressedX = x;
        mousePressedY = y;

        System.out.println("mouse clicked");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x, y;
        x = e.getX();
        y = e.getY();

        mouseReleasedX = x;
        mouseReleasedY = y;

        System.out.println("mouse released");
        checkIntersections();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x, y;
        x = e.getX();
        y = e.getY();

        mouseX = x;
        mouseY = y;
        System.out.println("Mouse dragged at " + x + ", " + y);

        System.out.println("Mouse dragged at");
        checkIntersections();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}