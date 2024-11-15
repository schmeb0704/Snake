package Snake;

import Main.GamePanel;

import java.awt.*;

public class SnakeFood {
    public static int x, y;
    static int size = 15;
    public static boolean isEaten = false;
    public static int numEaten = 0;

    public void setCoordinates(int x, int y){
        SnakeFood.x = x;
        SnakeFood.y = y;
    }

    public static void resetNumEaten(){
        numEaten = 0;
    }

    public static void updateCoordinates(){
        int new_x = (int) Math.floor(Math.random() * (GamePanel.WIDTH - SnakeBody.size));
        int new_y = (int) Math.floor(Math.random() * (GamePanel.HEIGHT - SnakeBody.size));

        x = new_x;
        y = new_y;
    }

    public void drawFood(Graphics2D g){
        g.setColor(Color.red);
        g.fillOval(x, y, size,size);
    }
}
