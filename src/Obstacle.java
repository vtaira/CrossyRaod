import java.awt.*;

public class Obstacle {
    int locX;
    int locY;
    int speed;
    int height;
    int width;
    Image image;

    public Obstacle(int locX, int locY, int width, int height, int speed, Image image ){
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

    public int getSpeed() {
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
        if(locX + width > 800){
            locX = 0;
        }
    }

    public void draw(Graphics g){
        g.drawImage(image, locX, locY, width, height, null);
    }
}

