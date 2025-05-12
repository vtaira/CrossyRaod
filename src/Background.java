import javax.swing.*;
import java.awt.*;

// Class for the background Image
public class Background {
    // Gives it access to GameView
    private GameView crossyRoad;
    private Image background1;

    // Constructor
    public Background(GameView crossyRoad){
        // Initializes GameView object
        // Sets background
        this.crossyRoad = crossyRoad;
        background1 = new ImageIcon("Resources/CR_background1.jpg").getImage();

    }

    // Draws background
    public void draw(Graphics g){
           g.drawImage(background1, 0, 0, crossyRoad);

    }
}


