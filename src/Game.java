import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
   private GameView window;
   private Player p;
   public static final int  stepSize = 10;



    public Game(){
        p = new Player();
        window = new GameView(this);
        window.addKeyListener(this);
        window.repaint();



    }
    public Player getPlayer(){
        return p;
    }


    public boolean isOver(){
        return false;
    }

    public static void main(String[] args){
            Game one = new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                p.moveX(-stepSize, 0, window.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                p.moveX(stepSize, 0, window.WINDOW_WIDTH);
                break;
            case KeyEvent.VK_UP:

                p.moveY(-stepSize, 0, window.WINDOW_HEIGHT);
                break;
            case KeyEvent.VK_DOWN:
                p.moveY(stepSize, 0, window.WINDOW_HEIGHT);
                break;
        }
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
