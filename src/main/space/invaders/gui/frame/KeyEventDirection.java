package main.space.invaders.gui.frame;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public enum KeyEventDirection {
    NO_DIRECTION(0, 0),
    RIGHT(KeyEvent.VK_RIGHT, 1),
    LEFT(KeyEvent.VK_LEFT, -1),
    SPACE(KeyEvent.VK_SPACE, 0);

    private final int sign;
    private final int value;

    KeyEventDirection(int value, int sign) {
        this.sign = sign;
        this.value = value;
    }

    public int getSign() {
        return sign;
    }

    public static KeyEventDirection getBasedOnKeyEventValue(int value) {
        return Arrays.stream(KeyEventDirection.values())
                .filter(e -> e.value == value)
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Undefined key pressed, returning NO_DIRECTION for key: " + value);
                    return NO_DIRECTION;
                });
    }
}
