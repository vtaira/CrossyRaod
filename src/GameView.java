import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class GameView extends JFrame {
   // Instance variables
   // Gives GameView access to Game, Background, and Player
    private Game game;
    public static int WINDOW_WIDTH = 900;
   public static int WINDOW_HEIGHT = 700;
   private Background background;
   private Player p;

   // Constructor
   public GameView(Game game){
       // Initializes background
       this.background = new Background(this);
       this.game = game;
       // Sets up window
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("The Aquarium");
       this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       this.setVisible(true);
       createBufferStrategy(2);

   }

    // To avoid flickering, sets up a second background as a buffer
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

    // Paints the background
    public void myPaint(Graphics g){
       super.paint(g);
       background.draw(g);
        game.getPlayer().draw(g);
        // Draws each obstacle
        for(Obstacle obstacle : game.getObstacles()){
            obstacle.draw(g);
        }
        // If the game is over
        // Write game over in the window
        if(game.isGameOver() == true){
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.setColor(Color.RED);
            g.drawString("GAME OVER!", 300, 350);
        }

    }
}