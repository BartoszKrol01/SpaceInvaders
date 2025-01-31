package main.space.invaders.animator.key.listener;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public enum KeyEventMapped {
    NO_DIRECTION(0, 0),
    RIGHT(KeyEvent.VK_RIGHT, 1),
    LEFT(KeyEvent.VK_LEFT, -1),
    SPACE(KeyEvent.VK_SPACE, 0),
    ESC(KeyEvent.VK_ESCAPE, 0),
    P(KeyEvent.VK_P, 0);

    private int sign;
    private final int value;

    KeyEventMapped(int value, int sign) {
        this.sign = sign;
        this.value = value;
    }

    public int getSign() {
        return sign;
    }

    public static KeyEventMapped getBasedOnKeyEventValue(int value) {
        return Arrays.stream(KeyEventMapped.values())
                .filter(e -> e.value == value)
                .findFirst()
                .orElseGet(() -> {
                    System.err.println("Undefined key pressed, returning NO_DIRECTION for key: " + value);
                    return NO_DIRECTION;
                });
    }

    private void setSign(int sign) {
        this.sign = sign;
    }

    public static void switchLeftAndRightKeySings() {
        RIGHT.setSign(RIGHT.sign * -1);
        LEFT.setSign(LEFT.sign * -1);
    }
}
