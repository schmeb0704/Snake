package Snake;

import java.awt.*;

import Main.GamePanel;
import Utils.KeyHandler;

public class SnakeBody {
    public int x,y, right_x, bottom_y;
    int size = 40;
    int movementSpeed = 5;
    boolean leftEdgeCollision, rightEdgeCollision, topEdgeCollision, bottomEdgeCollision;

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
        right_x = x + size;
        bottom_y = y + size;
    }

    public void edgeCollisionCheck(){
        leftEdgeCollision = rightEdgeCollision = topEdgeCollision = bottomEdgeCollision = false;

        if(x+size == GamePanel.WIDTH){
            rightEdgeCollision = true;
        }

        if(x == 0){
            leftEdgeCollision = true;
        }
        if(y == GamePanel.HEIGHT-50){
            bottomEdgeCollision = true;
        }
        if(y == 0){
            topEdgeCollision = true;
        }
    }

    public void checkFoodCollision(){
        if(SnakeFood.x >= x && SnakeFood.x <= right_x && SnakeFood.y < bottom_y && SnakeFood.y > y){
            SnakeFood.isEaten = true;
            SnakeFood.updateCoordinates();
        }
    }

    public void update(){
        edgeCollisionCheck();
        checkFoodCollision();

        if(!leftEdgeCollision && !rightEdgeCollision && !topEdgeCollision && !bottomEdgeCollision ){
            if(KeyHandler.downPressed){
                y += movementSpeed;
                bottom_y += movementSpeed;
            }
            if(KeyHandler.upPressed){
                y -= movementSpeed;
                bottom_y -= movementSpeed;
            }
            if(KeyHandler.rightPressed){
                x += movementSpeed;
                right_x += movementSpeed;
            }
            if(KeyHandler.leftPressed){
                x -= movementSpeed;
                right_x -= movementSpeed;
            }
        }
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect(x, y, size, size);

    }
}
