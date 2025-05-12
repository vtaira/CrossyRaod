import java.awt.*;

public class Obstacle {
   // Instance Variables
    private int locX;
  private  int locY;
   private double speed;
   private int height;
   private int width;
  private  Image image;
  private Player duck;

    // Constructors
    public Obstacle(int locX, int locY, int width, int height, double speed, Image image, Player duck ){
        // Initializes all variables
        this.locX = locX;
        this.locY = locY;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.image = image;
        this.duck = duck;

    }
    // Returns an obstacle's X position
    public int getLocX(){
        return locX;
    }
    // Returns an obstacle's Y position
    public int getLocY() {
        return locY;
    }

    // Returns an obstacle's speed
    public double getSpeed() {
        return speed;
    }

    // Returns an obstacle's height
    public int getHeight() {
        return height;
    }

    // Returns an obstacles width
    public int getWidth() {
        return width;
    }

    // Updates the obstacle's location
    public void update(){
        locX += speed;
        // If the obstacle has reached the far right edge of the window
        // Reset its position to the far left
        if(locX + width > 900){
            locX = 0;
        }
    }

    // Draws the obstacles
    public void draw(Graphics g){
        g.drawImage(image, locX, locY, width, height, null);
    }
}

