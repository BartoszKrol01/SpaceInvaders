package main.space.invaders.exception;

public class UnknownMissileSourceException extends InternalException {
    public UnknownMissileSourceException(String message) {
        super(message);
    }
}
