import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Row {
    private GameView crossyRoad;
    int location;
    ArrayList<Obstacles> obstacles;
    private Image desert, mountains, river, road;
    ArrayList<Image> originalRows;
    Image[] rows = new Image[20];

    public Row(){
        desert = new ImageIcon("Resources/CR_desert copy.png").getImage();
        originalRows.add(desert);
        mountains = new ImageIcon("Resources/CR_mountains.png").getImage();
        originalRows.add(mountains);
        river = new ImageIcon("Resources/CR_river copy.png").getImage();
        originalRows.add(river);
        road = new ImageIcon("Resources/CR_road.png").getImage();
        originalRows.add(road);
    }
    public void backgroundRows(Image[] rows){
        for(int i = 0; i < rows.length; i++){
            rows[i] = originalRows.get((int) (Math.random() * originalRows.size()) + 1);
        }
    }

    public void update(){

    }
    public void setObstacles(){

    }
    public void setRowType(){

    }
    public void draw(Graphics g){
        for(int i = 0; i < rows.length; i++){
            g.drawImage(rows[i], 350, 100, crossyRoad);
        }
    }
}
