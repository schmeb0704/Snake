package Main;

import DrawingHelpers.PlayArea;
import Snake.SnakeFood;
import Snake.SnakeBody;
import Utils.KeyHandler;

import java.awt.*;

public class PlayManager {
    final int WIDTH = 400;
    final int HEIGHT = 400;
    public static int left_x;
    public int bottom_y;
    public int right_x;
    public int top_y;
    final int  SNAKE_START_X = 100;
    final int  SNAKE_START_Y = 500;
    int food_start_x;
    int food_start_y;
    SnakeBody body;
    SnakeFood food;
    public static boolean isGameOver = false;

    public PlayManager(){
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        top_y = 50;

        body = new SnakeBody();
        body.setXY(SNAKE_START_X, SNAKE_START_Y);

        food = new SnakeFood();
        randomizeFoodCoords();
        food.setCoordinates(food_start_x, food_start_y);

    }

    private void randomizeFoodCoords(){
        food_start_x = (int) Math.floor(Math.random() * (GamePanel.WIDTH - SnakeBody.size));
        food_start_y = (int) Math.floor(Math.random() * (GamePanel.HEIGHT - SnakeBody.size));
    }

    private void gameRestart(){
        body.setXY(SNAKE_START_X, SNAKE_START_Y);
        randomizeFoodCoords();
        food.setCoordinates(food_start_x, food_start_y);
        KeyHandler.restartPressed = false;
        isGameOver = false;
    }

    public void update(){
        if(KeyHandler.restartPressed){
            gameRestart();
        } else {
            body.update();
        }
    }




    public void drawComponent(Graphics2D graphics){
//        PlayArea playArea = new PlayArea(left_x, top_y, WIDTH, HEIGHT);
//        playArea.drawPlayArea(graphics);

        // test moving rectangle
        body.drawBody(graphics);

        // draw food
        food.drawFood(graphics);

        // draw paused
        if(isGameOver){
            graphics.setColor(Color.yellow);
            graphics.drawString("GAME OVER! Press Shift to Restart", 400, 300);
        }
    }

}
