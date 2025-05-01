import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


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
       createBufferStrategy(2);

   }


    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g){
       super.paint(g);
       background.draw(g);
        game.getPlayer().draw(g);
        for(Obstacle obstacle : game.getObstacles()){
            obstacle.draw(g);
        }

    }
}