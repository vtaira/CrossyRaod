public class Game {
   private GameView window;
   private Player p;



    public Game(){
        p = new Player(window);
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
