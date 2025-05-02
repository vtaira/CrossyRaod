import java.awt.*;

public class Obstacle {
    int locX;
    int locY;
    double speed;
    int height;
    int width;
    Image image;

    public Obstacle(int locX, int locY, int width, int height, double speed, Image image ){
        this.locX = locX;
        this.locY = locY;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.image = image;

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
        if(locX + width > 900){
            locX = 0;
        }
    }

    public void draw(Graphics g){
        g.drawImage(image, locX, locY, width, height, null);
    }
}

