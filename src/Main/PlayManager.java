package Main;

import DrawingHelpers.PlayArea;
import Snake.SnakeFood;
import SnakeBody.SnakeBody;

import java.awt.*;

public class PlayManager {
    final int WIDTH = 400;
    final int HEIGHT = 400;
    public static int left_x;
    public int bottom_y;
    public int right_x;
    public int top_y;
    SnakeBody body;
    SnakeFood food;

    public PlayManager(){
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        top_y = 50;
        final int  SNAKE_START_X = 100;
        final int  SNAKE_START_Y = 500;
        int food_start_x = (int) Math.floor(Math.random() * GamePanel.WIDTH);
        int food_start_y = (int) Math.floor(Math.random() * GamePanel.HEIGHT);

        body = new SnakeBody();
        body.setXY(SNAKE_START_X, SNAKE_START_Y);

        food = new SnakeFood();
        food.setCoordinates(food_start_x, food_start_y);

    }

    public void update(){
        body.update();
    }




    public void drawComponent(Graphics2D graphics){
//        PlayArea playArea = new PlayArea(left_x, top_y, WIDTH, HEIGHT);
//        playArea.drawPlayArea(graphics);

        // test moving rectangle
        body.drawBody(graphics);

        // draw food
        food.drawFood(graphics);
    }

}
