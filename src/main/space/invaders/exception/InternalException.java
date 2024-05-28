package main.space.invaders.exception;

import javax.swing.JOptionPane;
import java.util.Arrays;

public abstract class InternalException extends RuntimeException {

    protected InternalException(String message, Throwable cause) {
        super(message, cause);
        showErrorDialog(cause);
    }

    protected InternalException(String message) {
        super(message);
        showErrorDialog(null);
    }

    private void showErrorDialog(Throwable cause) {
        String errorMessage = "An internal error has occurred. Game will be closed." + "\n" + this.getMessage();
        if (cause != null) {
            errorMessage = errorMessage + "\n" + cause.getMessage() + "\n" + formatStackTrace(cause.getStackTrace());
        }
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    private static String formatStackTrace(StackTraceElement[] stackTraceElements) {
        return Arrays.toString(stackTraceElements).replaceAll(",", "\n");
    }
}
