package main.space.invaders.gui.frame;

import main.space.invaders.drawable.Spaceship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.space.invaders.gui.frame.DirectionService.isSpaceShipAtBorder;

public class GameFrameKeyListener implements KeyListener {

    private final DirectionService directionService;

    public GameFrameKeyListener() {
        this.directionService = new DirectionService();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            System.out.println("LEFT");
        }
        Spaceship spaceship = Spaceship.getSpaceship();
        KeyEventDirection direction = KeyEventDirection.getBasedOnKeyEventValue(e.getKeyCode());
        if (!isSpaceShipAtBorder(direction, spaceship.getXLocation())) {
            int changeValue = directionService.handleKeyPressed(direction);
            spaceship.changeSpaceshipLocation(changeValue);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        directionService.setChangeValue(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
