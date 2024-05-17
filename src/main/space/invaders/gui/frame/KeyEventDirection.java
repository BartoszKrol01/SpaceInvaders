package main.space.invaders.gui.frame;

import java.util.Arrays;

public enum KeyEventDirection {
    NO_DIRECTION(0, 0),
    RIGHT(39, 1),
    LEFT(37, -1);
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
                .orElse(NO_DIRECTION);
    }
}
