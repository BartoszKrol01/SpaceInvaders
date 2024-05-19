package main.space.invaders.exception;

public class ThreadSleepException extends RuntimeException {
    public ThreadSleepException(String message, Throwable cause) {
        super(message, cause);
    }
}
