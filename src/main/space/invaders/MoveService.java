package main.space.invaders;

import main.space.invaders.settings.GameDisplay;
import main.space.invaders.utils.distribution.DataDistributor;

import static main.space.invaders.settings.SpaceshipDisplay.SPACESHIP_SIZE;

public class MoveService {

    private static final int MAX_CHANGE_VALUE = 9;
    private static final int CHANGE_VALUE_STEP = 3;
    private int changeValue;
    private KeyEventMapped arrowDirection;

    public MoveService() {
        this.changeValue = 0;
        this.arrowDirection = KeyEventMapped.NO_DIRECTION;
    }

    public int handleKeyPressed(KeyEventMapped arrowDirection) {
        if (arrowDirection == this.arrowDirection) {
            changeValue = Math.abs(changeValue) <= MAX_CHANGE_VALUE ? changeValue + (CHANGE_VALUE_STEP * arrowDirection.getSign()) : changeValue;
        } else {
            this.arrowDirection = arrowDirection;
            changeValue = 0;
        }
        return adjustChangeValue(changeValue, arrowDirection);
    }

    public static boolean isSpaceShipAtBorder(KeyEventMapped direction, int xLocation) {
        boolean isAtLeftBorder = xLocation <= -2 && direction == KeyEventMapped.LEFT;
        boolean isAtRightBorder = xLocation >= GameDisplay.getGamePanelWidth() - SPACESHIP_SIZE + 1 && direction == KeyEventMapped.RIGHT;
        return isAtRightBorder || isAtLeftBorder;
    }

    public static int handleButtonClicked(KeyEventMapped arrowDirection) {
        return MAX_CHANGE_VALUE * arrowDirection.getSign();
    }

    public void setChangeValue(int changeValue) {
        this.changeValue = changeValue;
    }

    private static int adjustChangeValue(int changeValue, KeyEventMapped direction) {
        int spaceShipXLocation = DataDistributor.getSpaceship().getXLocation();
        while (isSpaceShipAtBorder(direction, spaceShipXLocation + changeValue)) {
            changeValue = changeValue - direction.getSign();
        }
        return changeValue;
    }
}
