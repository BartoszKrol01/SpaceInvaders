package main.space.invaders.exception;

import java.io.IOException;

public class FileLoadException extends RuntimeException {

    public FileLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
