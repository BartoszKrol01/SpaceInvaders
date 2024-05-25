package main.space.invaders.exception.thread;

import main.space.invaders.exception.InternalException;

public class ThreadWaitException extends InternalException {
    public ThreadWaitException(String message, Throwable cause) {
        super(message, cause);
    }
}
