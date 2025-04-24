import javax.swing.*;
import java.awt.*;

public class Player {
    private GameView crossyRoad;
    private int locX = 350;
    private int locY = 620;
    private int height = 80;
    private int width = 110;
    private Image character;

    public Player(GameView crossyRoad){
        this.crossyRoad = crossyRoad;
        this.character = new ImageIcon("Resources/CR_duck.png").getImage();
        this.locX = locX;
        this.locY = locY;
        this.height = height;
        this.width = width;
    }

    public void move(){

    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void resetPosition(){

    }

    public void draw(Graphics g){
        g.drawImage(character, locX, locY, width, height, crossyRoad);
    }
}
