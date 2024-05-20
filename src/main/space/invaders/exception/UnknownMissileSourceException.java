package main.space.invaders.exception;

public class UnknownMissileSourceException extends RuntimeException {
    public UnknownMissileSourceException(String message) {
        super(message);
    }
}
