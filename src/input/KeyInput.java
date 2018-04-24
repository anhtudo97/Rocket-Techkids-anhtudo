package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    public static final KeyInput instance = new KeyInput();

    public boolean upPressed = false;
    public boolean upRelease = false;
    public boolean leftPressed = false;
    public boolean leftRelease = false;
    public boolean rightPressed = false;
    public boolean rightRelease = false;
    public boolean spacePressed = false;
    public boolean spaceRelease = false;

    private KeyInput() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spacePressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spaceRelease = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upRelease = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftRelease = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightRelease = true;
        }
    }

    public void reset(){
        this.upPressed = false;
        this.upRelease = false;
        this.leftPressed = false;
        this.leftRelease = false;
        this.rightPressed = false;
        this.rightRelease = false;
        this.spacePressed = false;
        this.spaceRelease = false;
    }


}
