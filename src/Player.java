import javax.swing.*;
import java.awt.*;


import static java.awt.SystemColor.window;

public class Player {
    private int locX = 375;
    private int locY = 620;
    private int height = 80;
    private int width = 110;
    private Image character;

    public Player() {
        this.character = new ImageIcon("Resources/CR_duck.png").getImage();
        this.locX = locX;
        this.locY = locY;
        this.height = height;
        this.width = width;

    }

    public void moveX(Player p, int xShift, int min, int max) {
        if(locX + xShift < min && xShift < 0){
            locX = min;
        }
        else if (locX + width + xShift > max && xShift > 0){
            locX = max - width;
        }
        else{
            locX += xShift;
        }

    }

    public void moveY(Player p, int yShift, int min, int max) {
        if(locY + yShift < min && yShift < 0){
            locY = min;
            p.resetPosition();
        }
        else if(locY + height + yShift > max && yShift > 0){
            locY = max - height;
        }
        else{
            locY += yShift;
        }

    }


    public void resetPosition() {
        locY = 620;
        locX = 375;
    }

    public void draw(Graphics g) {
        g.drawImage(character, locX, locY, width, height, null);
    }
}
