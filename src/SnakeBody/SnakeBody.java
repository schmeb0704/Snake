package SnakeBody;

import java.awt.*;
import Utils.KeyHandler;

public class SnakeBody {
    public int x,y;
    int movementSpeed = 8;

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(){
        if(KeyHandler.downPressed){
            y += movementSpeed;
            KeyHandler.downPressed = false;
        }
        if(KeyHandler.upPressed){
            y -= movementSpeed;
            KeyHandler.upPressed = false;
        }
        if(KeyHandler.rightPressed){
            x += movementSpeed;
            KeyHandler.rightPressed = false;
        }
        if(KeyHandler.leftPressed){
            x -= movementSpeed;
            KeyHandler.leftPressed = false;
        }
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 40);

    }
}
