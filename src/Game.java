import java.awt.*;
import java.util.ArrayList;

public class Game {
   private GameView window;
   private Player p;
   Row[] rows;


    public Game(){
        rows = new Row[20];
        for(int i = 0; i < 20; i++){
            rows[i] = new Row(window);
        }
        window = new GameView(this);
        window.repaint();



    }
    public boolean isOver(){
        return false;
    }

    public static void main(String[] args){
            Game one = new Game();
    }
}
