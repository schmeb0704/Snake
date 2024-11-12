package Snake;

import Main.GamePanel;

import java.awt.*;

public class SnakeFood {
    public static int x, y;
    static int size = 20;
    public static boolean isEaten = false;

    public void setCoordinates(int x, int y){
        SnakeFood.x = x;
        SnakeFood.y = y;
    }

    public static void updateCoordinates(){
        int new_x = (int) Math.floor(Math.random() * GamePanel.WIDTH);
        int new_y = (int) Math.floor(Math.random() * GamePanel.HEIGHT);

        x = new_x;
        y = new_y;
    }

    public void drawFood(Graphics2D g){
        g.setColor(Color.red);
        g.fillOval(x, y, size,size);
    }
}
