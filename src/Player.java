import javax.swing.*;
import java.awt.*;


public class Player {
    // Instance variables
    private int locX = 375;
    private int locY = 650;
    private int height = 45;
    private int width = 50;
    private Image character;

    // Constructor
    // Sets each variable, intializes the character's image
    public Player() {
        this.character = new ImageIcon("Resources/CR_duck.png").getImage();
        this.locX = locX;
        this.locY = locY;
        this.height = height;
        this.width = width;


    }

    // Returns the player's x coordinate
    public int getLocX() {
        return locX;
    }

    // Returns the player's y coordinate
    public int getLocY() {
        return locY;
    }

    // Moves the player left and right
    public void moveX(Player p, int xShift, int min, int max) {
        // If the movement takes the player further left than the edge of the visible window
        // Reset the X position to the minimum
        if(locX + xShift < min && xShift < 0){
            locX =  min;
        }
        // If the movement take the player further than the right edge
        // Reset the X position to the max
        else if (locX + xShift > max && xShift > 0){
            locX = max;
        }
        // Else, move the player
        else{
            locX += xShift;
        }

    }

    // Moves the player up and down
    public void moveY(Player p, int yShift, int min, int max, Game game) {
        // If the player reaches the top edge
        // Sets the game as over, and resets the player's position
        if(locY + yShift < min && yShift < 0){
            game.setGameOver(true);
            p.resetPosition();
        }
        // If the player tries to go further than the bottom edge
        // Reset the player back to the original position
        else if(locY + height + yShift > max && yShift > 0){
            locY = max - height;
            p.resetPosition();
        }
        // Else, move the player
        else{
            locY += yShift;
        }

    }

    // Resets the player's position to the start line
    public void resetPosition() {
        locY = 650;
        locX = 375;
    }

    // Draws the player
    public void draw(Graphics g) {
        g.drawImage(character, locX, locY, width, height, null);

    }
}
