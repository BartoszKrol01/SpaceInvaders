package main.space.invaders;

public class PauseService {

    private static boolean isGamePaused;

    static {
        isGamePaused = false;
    }

    public static boolean gamePaused() {
        return isGamePaused;
    }

    public static void setIsGamePaused(boolean isGamePaused) {
        PauseService.isGamePaused = isGamePaused;
    }

    private PauseService() {}
}
