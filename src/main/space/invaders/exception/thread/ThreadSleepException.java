package main.space.invaders.exception.thread;

import main.space.invaders.exception.InternalException;

public class ThreadSleepException extends InternalException {
    public ThreadSleepException(String message, Throwable cause) {
        super(message, cause);
    }
}
