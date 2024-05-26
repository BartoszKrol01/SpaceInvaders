package main.space.invaders.settings;

import static main.space.invaders.settings.MobDisplay.TOTAL_MOB_SIZE;

public class BarrierDisplay {

    public static final int BARRIER_SIZE = 2;
    public static final int BARRIERS_TRIANGLE_BASE = 41;
    public static final int BARRIERS_TRIANGLE_BASE_WIDTH = BARRIERS_TRIANGLE_BASE * BARRIER_SIZE;
    public static final int BARRIERS_TRIANGLE_HEIGHT = (BARRIERS_TRIANGLE_BASE + 1) / 2;
    public static int BARRIERS_TRIANGLES_NUMBER = 3;
    private static int gapBetweenBarriers;
    private static int barriersTriangleBaseStartY;

    static {
        recalculateBarrierDisplayValues();
    }

    public static int getBarriersTriangleBaseStartY() {
        recalculateBarrierDisplayValues();
        return barriersTriangleBaseStartY;
    }

    public static int getGapBetweenBarriers() {
        recalculateBarrierDisplayValues();
        return gapBetweenBarriers;
    }

    private static void recalculateBarrierDisplayValues() {
        barriersTriangleBaseStartY = SpaceshipDisplay.getSpaceshipStartY() - TOTAL_MOB_SIZE;
        gapBetweenBarriers = ((GameDisplay.getGamePanelWidth() - (2 * GameDisplay.SIDE_PANEL_GAP)) - 2 * BARRIERS_TRIANGLE_BASE_WIDTH) / 2 - BARRIERS_TRIANGLE_BASE_WIDTH / 2;
    }

    private BarrierDisplay() {}

}
