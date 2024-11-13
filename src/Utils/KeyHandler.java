package Utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public static boolean upPressed, downPressed, leftPressed, rightPressed, restartPressed;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W && !downPressed){
            upPressed = true;
            leftPressed = rightPressed = false;
        }

        if(code == KeyEvent.VK_A && !rightPressed){
            leftPressed = true;
            upPressed = downPressed = false;
        }

        if(code == KeyEvent.VK_S && !upPressed){
            downPressed = true;
            leftPressed = rightPressed = false;
        }

        if(code == KeyEvent.VK_D && !leftPressed){
            rightPressed = true;
            upPressed = downPressed = false;
        }
        if(code == KeyEvent.VK_SHIFT){
            restartPressed = true;
            upPressed = downPressed = rightPressed = leftPressed = false;
        }


    }

    public void keyReleased(KeyEvent e) {

    }
}
