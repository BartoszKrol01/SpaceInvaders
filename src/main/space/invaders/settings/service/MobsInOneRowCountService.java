package main.space.invaders.settings.service;

import main.space.invaders.animator.PauseService;

public class MobsInOneRowCountService {

    public static final int MOBS_IN_ONE_ROW_COUNT_DEFAULT = 11;
    private static int mobsInOneRowCount;

    static {
        mobsInOneRowCount = MOBS_IN_ONE_ROW_COUNT_DEFAULT;
    }

    public static void modifyMobsInOneRowCount(int newValue) {
        if (mobsInOneRowCount != newValue) {
            mobsInOneRowCount = newValue;
            PauseService.restartTheGame();
        }
    }

    public static int getMobsInOneRowCount() {
        return mobsInOneRowCount;
    }

    private MobsInOneRowCountService() {}

}
