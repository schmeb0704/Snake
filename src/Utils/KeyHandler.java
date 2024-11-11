package Utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public static boolean upPressed, downPressed, leftPressed, rightPressed;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
            downPressed = leftPressed = rightPressed = false;
        }

        if(code == KeyEvent.VK_A){
            leftPressed = true;
            rightPressed = upPressed = downPressed = false;
        }

        if(code == KeyEvent.VK_S){
            downPressed = true;
            upPressed = leftPressed = rightPressed = false;
        }

        if(code == KeyEvent.VK_D){
            rightPressed = true;
            leftPressed = upPressed = downPressed = false;
        }


    }

    public void keyReleased(KeyEvent e) {

    }
}
