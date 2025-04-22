import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Row {
    private GameView crossyRoad;
    int location;
    private ArrayList<Obstacles> obstacles;
    private Image background;

    public Row(GameView crossyRoad){
        this.crossyRoad = crossyRoad;
        int backgroundChoice = (int) (Math.random() * 4) + 1;
            if(backgroundChoice == 1){
                this.background = new ImageIcon("Resources/CR_desert copy.png").getImage();
            }
            else if (backgroundChoice == 2){
                this.background = new ImageIcon("Resources/CR_mountains.png").getImage();
           }
            else if (backgroundChoice == 3){
                this.background = new ImageIcon("Resources/CR_river copy.png").getImage();
            }
            else if (backgroundChoice == 4){
                this.background = new ImageIcon("Resources/CR_road.png").getImage();
            }
    }


    public void update(){

    }
    public void setObstacles(){

    }
    public void setRowType(){

    }
    public void draw(Graphics g){
       g.drawImage(background,0, 0, 900, 500, crossyRoad);
    }
}


