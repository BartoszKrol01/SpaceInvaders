package main.space.invaders.animator;

import main.space.invaders.KeyEventMapped;
import main.space.invaders.MoveService;
import main.space.invaders.drawable.shootable.spaceship.Spaceship;
import main.space.invaders.utils.distribution.DataDistributor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static main.space.invaders.MoveService.isSpaceShipAtBorder;

public class GameFrameKeyListener extends Animator implements KeyListener {

    private final MoveService moveService;
    private static final Set<KeyEventMapped> keysPressed;

    static {
        keysPressed = new HashSet<>();
    }

    public GameFrameKeyListener() {
        this.moveService = new MoveService();
        new Thread(this).start();
        DataDistributor.addAnimator(this);
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
            sleepTryCatch(20);
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
