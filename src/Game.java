import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;


public class Game implements KeyListener, ActionListener{
   private GameView window;
   private Player p;
   public static final int  stepSize = 15;
   private Obstacle[] obstacles;
   private Image[] obstacleImages;



    public Game(){
        p = new Player();
        window = new GameView(this);
        window.addKeyListener(this);
        obstacles = new Obstacle[24];
        obstacleImages = new Image[4];
        for (int i = 0; i < obstacleImages.length; i++){
            obstacleImages[i] = new ImageIcon("Resources/" + i + ".png").getImage();
        }
        addObstacles();
        window.repaint();


    }
    public void addObstacles(){
        for(int i = 0; i < obstacles.length; i ++){
            if(i < 6){
                int yVal = 520 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(120 * i, yVal, 75, 75, 1.7, obstacleImages[0], p);
            }
            else if (i >= 6 && i < 12){
               int yVal = 350 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(120 * (i-6), yVal, 75, 75, 1.7, obstacleImages[2], p);
            }
           else if (i >= 12 && i < 17){
                int yVal = 200 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(120 * (i - 11), yVal, 75, 75, 1.7, obstacleImages[3], p);
            }
           else if (i >= 17 && i <= 24){
                int yVal = 40 + (int)(Math.random() * 90);
                obstacles[i] = new Obstacle(120 * (i - 16), yVal, 50, 75, 1.7, obstacleImages[1], p);
            }
        }
    }

    public Player getPlayer(){
        return p;
    }


    public boolean isOver(){
        return false;
    }

    public static void main(String[] args){
            Game one = new Game();
            Timer timer = new Timer(16, one);
            timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                p.moveX(p, -stepSize, -20, window.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                p.moveX(p, stepSize, 0, window.WINDOW_WIDTH - 75);
                break;
            case KeyEvent.VK_UP:

                p.moveY(p, -stepSize, 0, window.WINDOW_HEIGHT);
                break;
            case KeyEvent.VK_DOWN:
                p.moveY(p, stepSize, -20, window.WINDOW_HEIGHT);
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Obstacle obstacle : obstacles){
            obstacle.update();
        }
        window.repaint();
    }

    public Obstacle[] getObstacles(){
        return obstacles;
    }
}
