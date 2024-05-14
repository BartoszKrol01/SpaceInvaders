package main.space.invaders.utils;

public class ThreadUtils {

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            //todo: handle exception
        }
    }
}
