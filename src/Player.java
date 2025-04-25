import javax.swing.*;
import java.awt.*;


import static java.awt.SystemColor.window;

public class Player {
    private int locX = 350;
    private int locY = 620;
    private int height = 80;
    private int width = 110;
    private int midHeight = 40;
    private int midWidth = 55;
    private Image character;

    public Player() {
        this.character = new ImageIcon("Resources/CR_duck.png").getImage();
        this.locX = locX;
        this.locY = locY;
        this.height = height;
        this.width = width;

    }

    public void moveX(int xShift, int min, int max) {
        if(locX - midWidth + xShift <= min && xShift < 0){
            locX = min + midWidth;
        }
        else if (locX + midWidth + xShift >= max && xShift > 0){
            locX = max - midWidth;
        }
        else{
            locX += xShift;
        }

    }

    public void moveY(int yShift, int min, int max) {
        if(locY - midHeight + yShift <= min && yShift < 0){
            locY = min + midHeight;
        }
        else if(locY + height + yShift >= max && yShift > 0){
            locY = max - height;
        }
        else{
            locY += yShift;
        }

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

    public void resetPosition() {

    }

    public void draw(Graphics g) {
        g.drawImage(character, locX, locY, width, height, null);
    }

}
