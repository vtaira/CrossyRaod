import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameView extends JFrame {
    private Game game;
    private int WINDOW_WIDTH = 900;
   private int WINDOW_HEIGHT = 700;



   public GameView(Game game){
       this.game = game;
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("The Aquarium");
       this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       this.setVisible(true);
   }
    public void actionPerformed(ActionEvent e){

    }
    public void paint(Graphics g){
        for(Row row : game.rows){
            row.draw(g);
        }

    }
}
