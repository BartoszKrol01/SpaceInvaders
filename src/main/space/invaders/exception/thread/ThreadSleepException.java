package main.space.invaders.exception.thread;

public class ThreadSleepException extends RuntimeException {
    public ThreadSleepException(String message, Throwable cause) {
        super(message, cause);
    }
}
