package main.space.invaders.gui.frame;

import main.space.invaders.PauseService;
import main.space.invaders.drawable.Spaceship;
import main.space.invaders.utils.Distributor;
import main.space.invaders.utils.ThreadUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static main.space.invaders.gui.frame.DirectionService.isSpaceShipAtBorder;

public class GameFrameKeyListener implements KeyListener, Runnable {

    private final DirectionService directionService;
    private final Set<KeyEventDirection> keysPressed;

    public GameFrameKeyListener() {
        this.directionService = new DirectionService();
        this.keysPressed = new HashSet<>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEventDirection direction = KeyEventDirection.getBasedOnKeyEventValue(e.getKeyCode());
        keysPressed.add(direction);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyEventDirection direction = KeyEventDirection.getBasedOnKeyEventValue(e.getKeyCode());
        keysPressed.remove(direction);
        directionService.setChangeValue(0);
    }

    @Override
    public void run() {
        while (!PauseService.gamePaused()) {
            Spaceship spaceship = Distributor.getSpaceship();
            if (keysPressed.contains(KeyEventDirection.RIGHT)) {
                handleKeyPressed(KeyEventDirection.RIGHT, spaceship);
            }
            if (keysPressed.contains(KeyEventDirection.LEFT)) {
                handleKeyPressed(KeyEventDirection.LEFT, spaceship);
            }
            ThreadUtils.sleep(20);
        }
    }

    private void handleKeyPressed(KeyEventDirection direction, Spaceship spaceship) {
        if (!isSpaceShipAtBorder(direction, spaceship.getXLocation())) {
            int changeValue = directionService.handleKeyPressed(direction);
            spaceship.changeSpaceshipLocation(changeValue);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
