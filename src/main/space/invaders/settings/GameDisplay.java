package main.space.invaders.settings;

import java.awt.Dimension;

public class GameDisplay {

    public static final int TOP_GAP_BETWEEN_PANEL_AND_FRAME = Mob.TOTAL_MOB_SIZE;
    public static final int SIDE_PANEL_GAP = Mob.MOB_STEP_SIZE * Mob.MOB_POSSIBLE_STEPS_SIDE + Mob.HALF_MOB_GAP;
    public static final int GAME_PANEL_WIDTH = Mob.TOTAL_MOB_SIZE * Mob.MOBS_IN_ONE_ROW_COUNT + SIDE_PANEL_GAP * 2;
    public static final int GAME_PANEL_HEIGHT = Mob.TOTAL_MOB_SIZE * Mob.NUMBER_OF_MOB_ROWS * 2 + TOP_GAP_BETWEEN_PANEL_AND_FRAME;

    public static Dimension getGameDimension() {
        return new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT);
    }

    private GameDisplay() {}
}
