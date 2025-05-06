import javax.swing.*;
import java.awt.*;


import static java.awt.SystemColor.window;

public class Player {
    private int locX = 375;
    private int locY = 640;
    private int height = 70;
    private int width = 85;
    private Image character;

    public Player() {
        this.character = new ImageIcon("Resources/CR_duck.png").getImage();
        this.locX = locX;
        this.locY = locY;
        this.height = height;
        this.width = width;

    }

    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public void moveX(Player p, int xShift, int min, int max) {
        if(locX + xShift < min && xShift < 0){
            locX =  min;
        }
        else if (locX + xShift > max && xShift > 0){
            locX = max;
        }
        else{
            locX += xShift;
        }

    }

    public void moveY(Player p, int yShift, int min, int max) {
        if(locY + yShift < min && yShift < 0){
            p.resetPosition();
        }
        else if(locY + height + yShift > max && yShift > 0){
            locY = max - height;
            p.resetPosition();
        }
        else{
            locY += yShift;
        }

    }


    public void resetPosition() {
        locY = 640;
        locX = 375;
    }

    public void draw(Graphics g) {
        g.drawImage(character, locX, locY, width, height, null);
    }
}
