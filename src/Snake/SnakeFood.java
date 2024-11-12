package Snake;

import java.awt.*;

public class SnakeFood {
    int x, y;
    int size = 30;

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void drawFood(Graphics2D g){
        g.setColor(Color.red);
        g.fillOval(x, y, size,size);
    }
}
