package main.space.invaders.exception.thread;

public abstract class ThreadException extends RuntimeException {
    //todo: make constructor show dialog and pauseAndRestart the game
    protected ThreadException(String message, Throwable cause) {
        super(message, cause);
    }
}
