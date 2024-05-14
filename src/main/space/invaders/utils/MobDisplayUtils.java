package main.space.invaders.utils;

import java.awt.*;

public class MobDisplayUtils {

    public static final int MOB_SIZE = 32;
    public static final int MOB_GAP = 18;
    public static final int TOTAL_MOB_SIZE = MOB_SIZE + MOB_GAP;
    public static final int HALF_MOB_GAP = MOB_GAP/2;
    public static final int TOP_GAP_BETWEEN_PANEL_AND_FRAME = TOTAL_MOB_SIZE;
    public static final int NUMBER_OF_ROWS_COUNT = 5;
    public static final int MOBS_IN_ONE_ROW_COUNT = 11;
    public static final int MOB_STEP_SIZE = 3;
    public static final int MOB_POSSIBLE_STEPS_SIDE = 9;
    public static final int FIRST_MOB_POSSIBLE_STEPS_DOWN = 5;
    public static final int SIDE_PANEL_GAP = MOB_STEP_SIZE * MOB_POSSIBLE_STEPS_SIDE + HALF_MOB_GAP;

    public static Dimension getGameDimension() {
        int width = TOTAL_MOB_SIZE * MOBS_IN_ONE_ROW_COUNT + SIDE_PANEL_GAP * 2;
        int height = TOTAL_MOB_SIZE * NUMBER_OF_ROWS_COUNT * 2 + TOP_GAP_BETWEEN_PANEL_AND_FRAME;
        return new Dimension(width, height);
    }

    private MobDisplayUtils() {}
}
