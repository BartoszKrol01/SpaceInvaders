package main.space.invaders.animator;

import main.space.invaders.utils.distribution.DataDistributor;

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
        isGamePaused = false;
        DataDistributor.getAnimators().forEach(Animator::resumeAnimation);
    }

    private PauseService() {}
}
