package main.space.invaders.animator;

import main.space.invaders.utils.distribution.DataDistributor;
import main.space.invaders.utils.distribution.SwingDistributor;

public class PauseService {

    private static boolean isGamePaused;
    private static final boolean running;

    static {
        running = true;
        isGamePaused = false;
    }

    public static boolean gamePaused() {
        return isGamePaused;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void pauseTheGame() {
        isGamePaused = true;
    }

    public static void unpauseTheGame() {
        if (isGamePaused) {
            isGamePaused = false;
            DataDistributor.getAnimators().forEach(Animator::resumeAnimation);
        } else {
            System.err.println("Game is already unpaused");
        }
    }

    public static void pauseOrUnpauseTheGame() {
        if (isGamePaused) {
            unpauseTheGame();
        } else {
            pauseTheGame();
        }
    }

    public static void restartTheGame() {
        GameFrameKeyListener.clearKeysPressedCache();
        SwingDistributor.getActivePlayerPanel().resetPanel();
        SwingDistributor.getRealTimePointsLabel().restartText();
        DataDistributor.populateData();
    }

    private PauseService() {}
}
