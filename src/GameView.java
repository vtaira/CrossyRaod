import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameView extends JFrame {
    private Game g;
    private int WINDOW_WIDTH = 900;
   private int WINDOW_HEIGHT = 700;



   public GameView(Game g){
        this.g = g;
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("The Aquarium");
       this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
       this.setVisible(true);
   }
    public void actionPerformed(ActionEvent e){

    }
    public void paint(){
       for(Image row :g.rows ){
            row.();
       }
    }
}
