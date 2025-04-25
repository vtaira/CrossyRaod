import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameView extends JFrame {
    private Game game;
    public static int WINDOW_WIDTH = 900;
   public static int WINDOW_HEIGHT = 700;
   private Background background;
   private Player p;



   public GameView(Game game){
       this.background = new Background(this);
       this.game = game;
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("The Aquarium");
       this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       this.setVisible(true);
   }
    public void actionPerformed(ActionEvent e){

    }
    public void paint(Graphics g){
        background.draw(g);
        game.getPlayer().draw(g);

    }
}
