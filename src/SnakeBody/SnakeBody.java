package SnakeBody;

import java.awt.*;

import Main.GamePanel;
import Main.PlayManager;
import Utils.KeyHandler;

public class SnakeBody {
    public int x,y;
    int size = 40;
    int movementSpeed = 5;
    boolean leftEdgeCollision, rightEdgeCollision, topEdgeCollision, bottomEdgeCollision;

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void edgeCollisionCheck(){
        leftEdgeCollision = rightEdgeCollision = topEdgeCollision = bottomEdgeCollision = false;

        if(x+size == PlayManager.left_x){
            leftEdgeCollision = true;
        }

    }

    public void update(){
        edgeCollisionCheck();

        if(!leftEdgeCollision && !rightEdgeCollision && !topEdgeCollision && !bottomEdgeCollision ){
            if(KeyHandler.downPressed){
                y += movementSpeed;
            }
            if(KeyHandler.upPressed){
                y -= movementSpeed;
            }
            if(KeyHandler.rightPressed){
                x += movementSpeed;
            }
            if(KeyHandler.leftPressed){
                x -= movementSpeed;
            }
        }
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect(x, y, size, size);

    }
}
