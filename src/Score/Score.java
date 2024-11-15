package Score;

import Main.GamePanel;
import Snake.SnakeFood;

import java.awt.*;

public class Score {
    public static int score = 0;

    public static void updateScore(){
        score = SnakeFood.numEaten * 10;
    }

    public void resetScore(){
        SnakeFood.resetNumEaten();
        score = 0;
    }

    public void drawScore(Graphics2D g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, GamePanel.WIDTH - 100, 50);
    }
}
