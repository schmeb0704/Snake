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
    public static ArrayList<SnakeSegment> tempSegments = new ArrayList<>();
    SnakeSegment head;
    SnakeSegment tail;

    public SnakeBody(){
        segments.add(new SnakeSegment());
        head = segments.getFirst();
        tail = segments.getLast();
    }


    public void setXY(int x, int y){
       head.x = x;
       head.y = y;
       head.right_x = x + SnakeSegment.size;
       head.bottom_y = y + SnakeSegment.size;
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

    public void addSegment(){
        SnakeSegment nextSegment = new SnakeSegment();
        if(KeyHandler.upPressed){
            nextSegment.x = tail.x;
            nextSegment.y = tail.bottom_y;
            nextSegment.bottom_y = nextSegment.y + SnakeSegment.size;
            nextSegment.right_x = nextSegment.x + SnakeSegment.size;
        }
        if(KeyHandler.downPressed){
            nextSegment.x = tail.x;
            nextSegment.y = tail.y - SnakeSegment.size;
            nextSegment.bottom_y = nextSegment.y + SnakeSegment.size;
            nextSegment.right_x = nextSegment.x + SnakeSegment.size;
        }

        if(KeyHandler.leftPressed){
            nextSegment.x = tail.right_x;
            nextSegment.y = tail.y;
            nextSegment.bottom_y = nextSegment.y + SnakeSegment.size;
            nextSegment.right_x = nextSegment.x + SnakeSegment.size;
        }
        if(KeyHandler.rightPressed){
            nextSegment.x = tail.x - SnakeSegment.size;
            nextSegment.y = tail.y;
            nextSegment.bottom_y = nextSegment.y + SnakeSegment.size;
            nextSegment.right_x = nextSegment.x + SnakeSegment.size;
        }
        segments.add(nextSegment);
        tail = nextSegment;
    }

    public void checkFoodCollision(){
        if(SnakeFood.x >= head.x && SnakeFood.x <= head.right_x && SnakeFood.y <= head.bottom_y && SnakeFood.y >= head.y){
            SnakeFood.isEaten = true;
            SnakeFood.updateCoordinates();
            addSegment();
        }
    }

    public void update(){
        edgeCollisionCheck();
        checkFoodCollision();

        if(!leftEdgeCollision && !rightEdgeCollision && !topEdgeCollision && !bottomEdgeCollision ){
            if(KeyHandler.downPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.y += movementSpeed;
                head.bottom_y += movementSpeed;
                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = tempSegments.get(i - 1).x;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
                tempSegments.clear();
//                for(SnakeSegment segment: segments){
//                    segment.y += movementSpeed;
//                    segment.bottom_y += movementSpeed;
//                }
            }
            if(KeyHandler.upPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.y -= movementSpeed;
                head.bottom_y -= movementSpeed;

                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = tempSegments.get(i - 1).x;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
//                for(SnakeSegment segment: segments){
//                    segment.y -= movementSpeed;
//                    segment.bottom_y -= movementSpeed;
//                }
            }
            if(KeyHandler.rightPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.x += movementSpeed;
                head.right_x += movementSpeed;

                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = tempSegments.get(i - 1).x;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
//                for(SnakeSegment segment: segments){
//                    segment.x += movementSpeed;
//                    segment.right_x += movementSpeed;
//                }
            }
            if(KeyHandler.leftPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.x -= movementSpeed;
                head.right_x -= movementSpeed;

                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = tempSegments.get(i - 1).x;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
//                for(SnakeSegment segment: segments){
//                    segment.x -= movementSpeed;
//                    segment.right_x -= movementSpeed;
//                }
            }
        } else{
            PlayManager.isGameOver = true;
        }
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);

//        System.out.println(segments.size());
        for (SnakeSegment segment : segments){
            g.fillRect(segment.x, segment.y, SnakeSegment.size, SnakeSegment.size);
        }

    }
}
