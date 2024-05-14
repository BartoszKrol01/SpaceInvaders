package main.space.invaders;

public class SameDirectionCounter {

    private static final int MAX_CHANGE_VALUE = 9;
    private static final int CHANGE_VALUE_STEP = 3;
    private int changeValue;
    private KeyEventDirection arrowDirection;

    public SameDirectionCounter() {
        this.changeValue = 0;
        this.arrowDirection = KeyEventDirection.NO_DIRECTION;
    }

    public int handleKeyPressed(KeyEventDirection arrowDirection) {
        if (arrowDirection == this.arrowDirection) {
            changeValue = Math.abs(changeValue) <= MAX_CHANGE_VALUE ? changeValue + (CHANGE_VALUE_STEP * arrowDirection.getSign()) : changeValue;
        } else {
            this.arrowDirection = arrowDirection;
            changeValue = 0;
        }
        return changeValue;
    }

    public void setChangeValue(int changeValue) {
        this.changeValue = changeValue;
    }
}
