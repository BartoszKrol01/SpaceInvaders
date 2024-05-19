package main.space.invaders.utils;

import main.space.invaders.PauseService;
import main.space.invaders.exception.ThreadSleepException;

public class ThreadUtils {

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            PauseService.setIsGamePaused(true);
            //todo: reset all components
            throw new ThreadSleepException("Exception during sleep", e);
        }
    }
}
