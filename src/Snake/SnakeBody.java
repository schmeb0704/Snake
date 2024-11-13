package Snake;

import java.awt.*;
import java.util.ArrayList;

import Main.GamePanel;
import Main.PlayManager;
import Utils.KeyHandler;

public class SnakeBody {
    public int x,y, right_x, bottom_y;
    public  static int size = 35;
    int movementSpeed = 5;
    boolean leftEdgeCollision, rightEdgeCollision, topEdgeCollision, bottomEdgeCollision;
    public static ArrayList<SnakeSegment> segments = new ArrayList<>();
    SnakeSegment head;

    public SnakeBody(){
        segments.add(new SnakeSegment());
        segments.add(new SnakeSegment());
        head = segments.getFirst();
    }


    public void setXY(int x, int y){
        segments.getFirst().x = x;
        segments.getFirst().y = y;
        segments.getFirst().right_x = x + SnakeSegment.size;
        segments.getFirst().bottom_y = x + SnakeSegment.size;
    }

    public void edgeCollisionCheck(){
        leftEdgeCollision = rightEdgeCollision = topEdgeCollision = bottomEdgeCollision = false;

        if(head.x + SnakeSegment.size == GamePanel.WIDTH){
            rightEdgeCollision = true;
        }

        if(head.x == 0){
            leftEdgeCollision = true;
        }
        if(head.y + size == GamePanel.HEIGHT){
            bottomEdgeCollision = true;
        }
        if(head.y == 0){
            topEdgeCollision = true;
        }
    }

    public void checkFoodCollision(){
        if(SnakeFood.x >= head.x && SnakeFood.x <= head.right_x && SnakeFood.y < head.bottom_y && SnakeFood.y > head.y){
            SnakeFood.isEaten = true;
            SnakeFood.updateCoordinates();
        }
    }

    public void update(){
        edgeCollisionCheck();
        checkFoodCollision();

        if(!leftEdgeCollision && !rightEdgeCollision && !topEdgeCollision && !bottomEdgeCollision ){
            if(KeyHandler.downPressed){
                for(SnakeSegment segment: segments){
                    segment.y += movementSpeed;
                    segment.bottom_y += movementSpeed;
                }
            }
            if(KeyHandler.upPressed){
                for(SnakeSegment segment: segments){
                    segment.y -= movementSpeed;
                    segment.bottom_y -= movementSpeed;
                }
            }
            if(KeyHandler.rightPressed){
                for(SnakeSegment segment: segments){
                    segment.x += movementSpeed;
                    segment.right_x += movementSpeed;
                }
            }
            if(KeyHandler.leftPressed){
                for(SnakeSegment segment: segments){
                    segment.x -= movementSpeed;
                    segment.right_x -= movementSpeed;
                }
            }
        } else{
            PlayManager.isGameOver = true;
        }
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);
//        g.fillRect(x, y, size, size);
        g.fillRect(segments.getFirst().x, segments.getFirst().y, SnakeSegment.size, SnakeSegment.size );
        g.fillRect(head.x, head.y,  SnakeSegment.size, SnakeSegment.size );

    }
}
