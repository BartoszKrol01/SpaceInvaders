package main.space.invaders.settings.service;

public class MobSleepTimeService {

    public static final int MOB_SLEEP_TIME_DEFAULT = 100;
    private static int mobSleepTime;
    private static boolean mobSleepTimeFixed = true;

    static {
        mobSleepTime = MOB_SLEEP_TIME_DEFAULT;
    }

    public static void modifyMobSleepTime(int newValue) {
        if (newValue <= 0) {
            newValue++;
        }
        mobSleepTime = newValue;
    }

    public static int getMobsSleepTime() {
        return mobSleepTime;
    }

    public static boolean isMobSleepTimeFixed() {
        return mobSleepTimeFixed;
    }

    public static void changeMobSleepTimeFixedFlag() {
        mobSleepTimeFixed = !mobSleepTimeFixed;
    }
}
