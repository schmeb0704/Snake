package Snake;

import java.awt.*;
import java.util.ArrayList;

import Main.GamePanel;
import Main.PlayManager;
import Score.Score;
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
        createSnakeEnds();
    }

    public void createSnakeEnds() {
        segments.clear(); // Clear any existing segments
        SnakeSegment initialSegment = new SnakeSegment(0, 0, SnakeSegment.size, SnakeSegment.size); // Starting position
        segments.add(initialSegment);
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
            SnakeFood.numEaten++;
            Score.updateScore();
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
                    segments.get(i).y = (tempSegments.get(i - 1).y - SnakeSegment.size) + movementSpeed * 2;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
                tempSegments.clear();
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
                    segments.get(i).y = (tempSegments.get(i - 1).y + SnakeSegment.size) - movementSpeed * 2;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
            }
            if(KeyHandler.rightPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.x += movementSpeed;
                head.right_x += movementSpeed;

                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = (tempSegments.get(i - 1).x - SnakeSegment.size) + movementSpeed * 2;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
            }
            if(KeyHandler.leftPressed){
                tempSegments.clear(); // Clear any previous data in tempSegments
                for (SnakeSegment segment : segments) {
                    tempSegments.add(new SnakeSegment(segment.x, segment.y, segment.right_x, segment.bottom_y));
                }
                head.x -= movementSpeed;
                head.right_x -= movementSpeed;

                for (int i = 1; i < segments.size(); i++) {
                    segments.get(i).x = (tempSegments.get(i - 1).x + SnakeSegment.size) - movementSpeed * 2;
                    segments.get(i).y = tempSegments.get(i - 1).y;
                    segments.get(i).bottom_y = tempSegments.get(i - 1).bottom_y;
                    segments.get(i).right_x = tempSegments.get(i - 1).right_x;
                }
            }
        } else{
            PlayManager.isGameOver = true;
        }
    }

    public void resetBody(){
        segments.clear();
        createSnakeEnds();
        int gridSize = SnakeBody.size; // Assuming SnakeBody.size is the size of one segment
        int new_x = (int) Math.floor(Math.random() * (((double) GamePanel.WIDTH / gridSize) - 1)) * gridSize;
        int new_y = (int) Math.floor(Math.random() * (((double) GamePanel.HEIGHT / gridSize) - 1)) * gridSize;
        setXY(new_x, new_y);
    }



    public void drawBody(Graphics2D g){
        g.setColor(Color.blue);

        final int MARGIN = 2;

        for (SnakeSegment segment : segments){
            g.fillRect(segment.x + MARGIN, segment.y + MARGIN, SnakeSegment.size - (2* MARGIN), SnakeSegment.size - (2* MARGIN));

            g.setColor(Color.white); // Border color
            g.drawRect(segment.x + MARGIN, segment.y + MARGIN,
                    SnakeSegment.size - (2 * MARGIN), SnakeSegment.size - (2 * MARGIN));
        }

    }
}
