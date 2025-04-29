import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Background {
    private GameView crossyRoad;
    int location;
    private ArrayList<Obstacle> obstacles;
    private Image background1;
    private Image background2;


    public Background(GameView crossyRoad){
        this.crossyRoad = crossyRoad;
        this.obstacles = new ArrayList<>();
        this.crossyRoad = crossyRoad;
        background1 = new ImageIcon("Resources/CR_background1.jpg").getImage();
        background2 = new ImageIcon("Resources/CR_Background2.jpg").getImage();

    }


    public void update(){

    }
    public void setObstacles(){

    }
    public void setRowType(){

    }
    public void draw(Graphics g){

           g.drawImage(background1, 0, 0, crossyRoad);

    }
}


