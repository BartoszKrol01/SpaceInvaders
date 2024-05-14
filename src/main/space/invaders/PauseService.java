package main.space.invaders;

public class PauseService {

    //todo

    private static final boolean isGamePaused;

    static {
        isGamePaused = false;
    }

    public static boolean gamePaused() {
        return isGamePaused;
    }

    private PauseService() {}
}
