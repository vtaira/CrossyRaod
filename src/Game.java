import java.awt.*;
import java.util.ArrayList;

public class Game {
    GameView window;
    Player p;
    Image[] rows;
    Row background;

    public Game(){
        window = new GameView(this);
        window.repaint();
        rows = background.rows;

    }
    public boolean isOver(){
        return false;
    }

    public static void main(String[] args){
            Game one = new Game();
    }
}
