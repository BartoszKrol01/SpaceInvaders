package main.space.invaders.exception.thread;

public abstract class ThreadException extends RuntimeException {
    protected ThreadException(String message, Throwable cause) {
        super(message, cause);
    }
}
