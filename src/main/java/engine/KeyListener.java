package engine;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private boolean keyUp;
    private boolean keyDown;
    private boolean arrowUp;
    private boolean arrowDown;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggleKeys(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggleKeys(e);
    }

    private void toggleKeys(KeyEvent e) {
        int code = e.getKeyCode();
        arrowUp = code == KeyEvent.VK_UP;
        arrowDown = code == KeyEvent.VK_DOWN;
        keyUp = code == KeyEvent.VK_W;
        keyDown = code == KeyEvent.VK_S;
    }

    public boolean isArrowDown() {
        return arrowDown;
    }

    public boolean isArrowUp() {
        return arrowUp;
    }

    public boolean isKeyDown() {
        return keyDown;
    }

    public boolean isKeyUp() {
        return keyUp;
    }
}
