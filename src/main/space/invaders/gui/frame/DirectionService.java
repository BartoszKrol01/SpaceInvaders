package main.space.invaders.gui.frame;

import main.space.invaders.utils.Distributor;

import static main.space.invaders.gui.GameDisplayConstants.GAME_PANEL_WIDTH;
import static main.space.invaders.gui.GameDisplayConstants.SPACESHIP_SIZE;

public class DirectionService {

    private static final int MAX_CHANGE_VALUE = 9;
    private static final int CHANGE_VALUE_STEP = 3;
    private int changeValue;
    private KeyEventDirection arrowDirection;

    public DirectionService() {
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
        return adjustChangeValue(changeValue, arrowDirection);
    }

    private static int adjustChangeValue(int changeValue, KeyEventDirection direction) {
        int spaceShipXLocation = Distributor.getSpaceship().getXLocation();
        while (isSpaceShipAtBorder(direction, spaceShipXLocation + changeValue)) {
            changeValue = changeValue - direction.getSign();
        }
        return changeValue;
    }

    public static boolean isSpaceShipAtBorder(KeyEventDirection direction, int xLocation) {
        boolean isAtLeftBorder = xLocation <= -2 && direction == KeyEventDirection.LEFT;
        boolean isAtRightBorder = xLocation >= GAME_PANEL_WIDTH - SPACESHIP_SIZE + 1 && direction == KeyEventDirection.RIGHT;
        return isAtRightBorder || isAtLeftBorder;
    }

    public void setChangeValue(int changeValue) {
        this.changeValue = changeValue;
    }
}
