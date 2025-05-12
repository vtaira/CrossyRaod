// Duck Crossing - By Veronica Taira
// May 10th, 2025

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;


public class Game implements KeyListener, ActionListener{
   // Instance Variables
   // Allows Game to access GameView
   private GameView window;
   private Player p;
   public static final int  stepSize = 16;
   private Obstacle[] obstacles;
   private Image[] obstacleImages;
    private boolean gameOver;

    // Constructor
    public Game(){
        this.gameOver = gameOver;
        p = new Player();
        window = new GameView(this);
        window.addKeyListener(this);
       // Initializes the array of Obstacles and Obstacle Images
        obstacles = new Obstacle[24];
        obstacleImages = new Image[4];

        // Fills the obstacleImages array with images
        for (int i = 0; i < obstacleImages.length; i++){
            obstacleImages[i] = new ImageIcon("Resources/" + i + ".png").getImage();
        }

        // Adds obstacle objects to the obstacles array
        addObstacles();
        window.repaint();


    }

    // Returns the state of gameOver
    // True - game is over
    // False - game isn't
    public boolean isGameOver() {
        return gameOver;
    }

    // Sets gameOver to true or false
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    // Adds obstacles to the obstacles array
    public void addObstacles(){
        for(int i = 0; i < obstacles.length; i ++){
            // If i < 6, choose a random place for the obstacle in the bottom quarter of the screen
            // Give the obstacle the car image
            if(i < 6){
                int yVal = 510 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(150 * i, yVal, 50, 50, 1.5, obstacleImages[0], p);
            }
            // Else if i is in between 6 and 12
            // Choose a random place for the obstacle in the 2nd to last quarter of the screen
            // Give the obstacle the fish image
            else if (i >= 6 && i < 12){
               int yVal = 350 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(130 * (i-6), yVal, 50, 50, 1.5, obstacleImages[2], p);
            }
            // Else if i is in between 12 and 17
            // Choose a place in the 2nd quarter of the screen for the obstacle
            // Give the obstacle the bird image
            else if (i >= 12 && i <= 17){
                int yVal = 200 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(130 * (i - 11), yVal, 50, 50, 1.5, obstacleImages[3], p);
            }
            // Else if i is greater than 17
            // Choose a place in the top quarter of the screen for the obstacle
            // Give the obstacle the cactus image
            else if (i > 17 && i <= 24){
                int yVal = 40 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(130 * (i - 16), yVal, 40, 60, 1.5, obstacleImages[1], p);
            }
        }
    }

    // Returns player object
    public Player getPlayer(){
        return p;
    }

    // Checks to see if the duck has hit an obstacle after a move
    public void checkDuck(){
        // Sets duck width and height into integer variables.
        int duckWidth = 55;
        int duckHeight = 50;

        // Goes through each obstacle in obstacles
        // Checks to see if the duck has hit any of the obstacles
        for (Obstacle obs : obstacles) {
            int obsX = obs.getLocX();
            int obsY = obs.getLocY();
            int obsWidth = obs.getWidth();
            int obsHeight = obs.getHeight();

            // If the duck has hit an obstacle, reset its position back to the start
            if (p.getLocX() < obsX + obsWidth && p.getLocX() + duckWidth > obsX && p.getLocY() < obsY + obsHeight && p.getLocY() + duckHeight > obsY)
            {
                p.resetPosition();
                break; // Stop checking after first collision
            }
        }
    }


    // Main function
    // Creates game object and starts timer
    public static void main(String[] args){
            Game one = new Game();
            Timer timer = new Timer(16, one);
            timer.start();
    }

    @Override
    // Part of KeyListener
    public void keyTyped(KeyEvent e) {

    }

    @Override
    // Once a key has been pressed
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            // If the key is the left arrow
            // Move the duck to the left
            case KeyEvent.VK_LEFT:
                p.moveX(p, -stepSize, -20, window.WINDOW_WIDTH);
                break;
            // If the key is the right arrow, move the duck right
            case KeyEvent.VK_RIGHT:
                p.moveX(p, stepSize, 0, window.WINDOW_WIDTH - 75);
                break;
            // If the key is the up arrow, move the duck up
            // For the up and down arrows, takes in the current game object
            case KeyEvent.VK_UP:
                p.moveY(p, -stepSize, 0, window.WINDOW_HEIGHT, this);
                break;
            // If the key is the down arrow, move the duck down
            case KeyEvent.VK_DOWN:
                p.moveY(p, stepSize, -20, window.WINDOW_HEIGHT, this);
                break;
        }
        window.repaint();
    }

    @Override
    // KeyListener method
    public void keyReleased(KeyEvent e) {

    }

    @Override
    // While the game isn't over
    // Keep updating the obstacles so they move across the screen
    // Check the duck with each movement
    public void actionPerformed(ActionEvent e) {
       if(!gameOver) {
           for (Obstacle obstacle : obstacles) {
               obstacle.update();
           }
           checkDuck();
           window.repaint();
       }
    }

    // Returns array of obstacles
    public Obstacle[] getObstacles(){
        return obstacles;
    }
}
