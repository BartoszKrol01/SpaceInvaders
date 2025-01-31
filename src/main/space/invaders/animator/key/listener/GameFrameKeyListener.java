package main.space.invaders.animator.key.listener;

import main.space.invaders.animator.Animator;
import main.space.invaders.animator.PauseService;
import main.space.invaders.drawable.shootable.spaceship.Spaceship;
import main.space.invaders.utils.distribution.DataDistributor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static main.space.invaders.animator.key.listener.MoveService.isSpaceShipAtBorder;

public class GameFrameKeyListener extends Animator implements KeyListener {

    private final MoveService moveService;
    private static final Set<KeyEventMapped> keysPressed;

    static {
        keysPressed = new HashSet<>();
    }

    public GameFrameKeyListener() {
        super();
        this.moveService = new MoveService();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEventMapped eventKey = KeyEventMapped.getBasedOnKeyEventValue(e.getKeyCode());
        if (eventKey == KeyEventMapped.ESC) {
            System.exit(0);
        }
        if (eventKey == KeyEventMapped.P) {
            PauseService.pauseOrUnpauseTheGame();
            return;
        }
        keysPressed.add(eventKey);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyEventMapped direction = KeyEventMapped.getBasedOnKeyEventValue(e.getKeyCode());
        keysPressed.remove(direction);
        moveService.setChangeValue(0);
    }

    @Override
    public void run() {
        while (PauseService.isRunning()) {
            if (PauseService.gamePaused()) {
                pauseAnimation();
            }
            Spaceship spaceship = DataDistributor.getSpaceship();
            if (keysPressed.contains(KeyEventMapped.RIGHT)) {
                handleKeyPressed(KeyEventMapped.RIGHT, spaceship);
            }
            if (keysPressed.contains(KeyEventMapped.LEFT)) {
                handleKeyPressed(KeyEventMapped.LEFT, spaceship);
            }
            if (keysPressed.contains(KeyEventMapped.SPACE)) {
                spaceship.fireMissile();
            }
            sleepTryCatch(16);
        }
    }

    public static void clearKeysPressedCache() {
        keysPressed.clear();
    }

    private void handleKeyPressed(KeyEventMapped direction, Spaceship spaceship) {
        if (!isSpaceShipAtBorder(direction, spaceship.getXLocation())) {
            int changeValue = moveService.handleKeyPressed(direction);
            spaceship.changeSpaceshipLocation(changeValue);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
