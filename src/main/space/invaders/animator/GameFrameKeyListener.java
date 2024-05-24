package main.space.invaders.animator;

import main.space.invaders.drawable.shootable.spaceship.Spaceship;
import main.space.invaders.gui.frame.DirectionService;
import main.space.invaders.gui.frame.KeyEventDirection;
import main.space.invaders.utils.distribution.DataDistributor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static main.space.invaders.drawable.missile.MissileVerificationService.shouldFireMoreMissiles;
import static main.space.invaders.gui.frame.DirectionService.isSpaceShipAtBorder;

public class GameFrameKeyListener extends Animator implements KeyListener {

    private final DirectionService directionService;
    private final Set<KeyEventDirection> keysPressed;

    public GameFrameKeyListener() {
        this.directionService = new DirectionService();
        this.keysPressed = new HashSet<>();
        new Thread(this).start();
        DataDistributor.addAnimator(this);
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
        while (PauseService.isRunning()) {
            if (PauseService.gamePaused()) {
                pauseAnimation();
            }
            Spaceship spaceship = DataDistributor.getSpaceship();
            if (keysPressed.contains(KeyEventDirection.RIGHT)) {
                handleKeyPressed(KeyEventDirection.RIGHT, spaceship);
            }
            if (keysPressed.contains(KeyEventDirection.LEFT)) {
                handleKeyPressed(KeyEventDirection.LEFT, spaceship);
            }
            if (keysPressed.contains(KeyEventDirection.SPACE)) {
                if (shouldFireMoreMissiles()) {
                    spaceship.fireMissile();
                }
            }
            sleepTryCatch(20);
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
