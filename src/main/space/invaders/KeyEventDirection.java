package main.space.invaders;

public enum KeyEventDirection {
    NO_DIRECTION(0),
    RIGHT(1),
    LEFT(-1);
    private final int sign;

    KeyEventDirection(int sign) {
        this.sign = sign;
    }

    public int getSign() {
        return sign;
    }
}
