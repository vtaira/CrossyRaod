import java.awt.*;

public class Obstacle {
   private int locX;
  private  int locY;
   private double speed;
   private int height;
   private int width;
  private  Image image;
  private Player duck;


    public Obstacle(int locX, int locY, int width, int height, double speed, Image image, Player duck ){
        this.locX = locX;
        this.locY = locY;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.image = image;
        this.duck = duck;

    }
    public int getLocX(){
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public double getSpeed() {
        return speed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void update(){
        locX += speed;
        if(locX == duck.getLocX()){
            duck.resetPosition();
        }
        if(locY == duck.getLocY()){
            duck.resetPosition();
        }
        if(locX + width > 900){
            locX = 0;
        }
    }

    public void draw(Graphics g){
        g.drawImage(image, locX, locY, width, height, null);
    }
}

