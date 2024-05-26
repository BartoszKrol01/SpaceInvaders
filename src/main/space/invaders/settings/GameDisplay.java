package main.space.invaders.settings;

import main.space.invaders.settings.service.MobsInOneRowCountService;
import main.space.invaders.settings.service.NumberOfMobRowsService;

import java.awt.Dimension;

public class GameDisplay {

    public static final int TOP_GAP_BETWEEN_PANEL_AND_FRAME = MobDisplay.TOTAL_MOB_SIZE;
    public static final int SIDE_PANEL_GAP = MobDisplay.MOB_STEP_SIZE * MobDisplay.MOB_POSSIBLE_STEPS_SIDE;
    private static int gamePanelWidth;
    private static int gamePanelHeight;

    static {
        recalculateGameDimension();
    }

    public static Dimension getGameDimension() {
        recalculateGameDimension();
        return new Dimension(gamePanelWidth, gamePanelHeight);
    }

    public static int getGamePanelWidth() {
        recalculateGameDimension();
        return gamePanelWidth;
    }

    public static int getGamePanelHeight() {
        recalculateGameDimension();
        return gamePanelHeight;
    }

    private static void recalculateGameDimension() {
        gamePanelWidth = MobDisplay.TOTAL_MOB_SIZE * MobsInOneRowCountService.getMobsInOneRowCount() + SIDE_PANEL_GAP * 2;
        gamePanelHeight = MobDisplay.TOTAL_MOB_SIZE * NumberOfMobRowsService.getNumberOfMobRows() * 2 + TOP_GAP_BETWEEN_PANEL_AND_FRAME;
    }

    private GameDisplay() {}
}
