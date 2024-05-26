package main.space.invaders.settings.service;

import main.space.invaders.animator.PauseService;
import main.space.invaders.drawable.shootable.mob.MobType;

public class NumberOfMobRowsService {

    public static final int NUMBER_OF_MOB_ROWS_DEFAULT = 5;
    public static int numberOfMobRows;

    static {
        numberOfMobRows = NUMBER_OF_MOB_ROWS_DEFAULT;
    }

    public static void modifyNumberOfMobRows(int newValue) {
        numberOfMobRows = newValue;
        MobType.calculateRowsOccupied(newValue);
        PauseService.restartTheGame();
    }

    public static int getNumberOfMobRows() {
        return numberOfMobRows;
    }
}
