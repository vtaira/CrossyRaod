import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;


public class Game implements KeyListener, ActionListener{
   private GameView window;
   private Player p;
   public static final int  stepSize = 10;
   private Obstacle[] obstacles;
   private Image[] obstacleImages;



    public Game(){
        p = new Player();
        window = new GameView(this);
        window.addKeyListener(this);
        window.repaint();
        obstacles = new Obstacle[20];
        obstacleImages = new Image[4];
        for (int i = 0; i < obstacleImages.length; i++){
            obstacleImages[i] = new ImageIcon("Resources/" + i + ".jpg").getImage();
        }
        addObstacles();


    }
    public void addObstacles(){
        for(int i = 0; i < obstacles.length; i ++){
            if(i < 6){
                obstacles[i] = new Obstacle(5, 600, 50, 50, 2, obstacleImages[0]);
            }
            else if (i >= 6 && i < 11){
                obstacles[i] = new Obstacle(5, 400, 50, 50, 2, obstacleImages[2]);
            }
           else if (i >= 11 && i < 16){
               obstacles[i] = new Obstacle(5, 200, 50, 50, 2, obstacleImages[3]);
            }
           else{
                obstacles[i] = new Obstacle(5, 100, 50, 50, 2, obstacleImages[2]);
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
                p.moveX(p, -stepSize, 0, window.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                p.moveX(p, stepSize, 0, window.WINDOW_WIDTH - 75);
                break;
            case KeyEvent.VK_UP:

                p.moveY(p, -stepSize, 0, window.WINDOW_HEIGHT);
                break;
            case KeyEvent.VK_DOWN:
                p.moveY(p, stepSize, 0, window.WINDOW_HEIGHT);
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
