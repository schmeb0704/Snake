package DrawingHelpers;

import java.awt.*;

public class PlayArea {
    int top_x;
    int top_y;
    int width;
    int height;

    public PlayArea(int top_x, int top_y, int width, int height){
        this.top_x = top_x;
        this.top_y = top_y;
        this.width = width;
        this.height = height;
    }

    public void drawPlayArea(Graphics2D g){
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(4f));
        g.drawRect(top_x, top_y, width, height);
    }
}
