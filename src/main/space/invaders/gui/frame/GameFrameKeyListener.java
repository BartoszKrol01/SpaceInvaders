package main.space.invaders.gui.frame;

import main.space.invaders.drawable.Spaceship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrameKeyListener implements KeyListener {

    private final SameDirectionCounter sameDirectionCounter;

    public GameFrameKeyListener() {
        this.sameDirectionCounter = new SameDirectionCounter();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int changeValue = sameDirectionCounter.handleKeyPressed(e.getKeyCode() == KeyEvent.VK_RIGHT ? KeyEventDirection.RIGHT : KeyEventDirection.LEFT);
        Spaceship.getSpaceship().changeSpaceshipLocation(changeValue);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        sameDirectionCounter.setChangeValue(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
