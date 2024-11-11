import Utils.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int HEIGHT = 720;
    public static final int WIDTH = 1000;
    private final int FPS = 60;
    PlayManager playManager = new PlayManager();
    Thread gameThread;



    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }
//        PlayArea playArea = new PlayArea(top_x, top_y, WIDTH, HEIGHT);
//        playArea.drawPlayArea(graphics);

        // test moving rectangle

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        //game loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        playManager.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        playManager.drawComponent(g2);
    }
}
