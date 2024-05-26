package main.space.invaders.settings;

import static main.space.invaders.settings.MobDisplay.TOTAL_MOB_SIZE;

public class BarrierDisplay {

    public static final int BARRIER_SIZE = 2;
    public static final int BARRIERS_TRIANGLE_BASE = 41;
    public static final int BARRIERS_TRIANGLE_BASE_WIDTH = BARRIERS_TRIANGLE_BASE * BARRIER_SIZE;
    public static final int GAP_BETWEEN_BARRIERS = ((GameDisplay.getGamePanelWidth() - (2 * GameDisplay.SIDE_PANEL_GAP)) - 2 * BARRIERS_TRIANGLE_BASE_WIDTH) / 2 - BARRIERS_TRIANGLE_BASE_WIDTH / 2;
    public static final int BARRIERS_TRIANGLE_HEIGHT = (BARRIERS_TRIANGLE_BASE + 1) / 2;
    public static final int BARRIERS_TRIANGLES_NUMBER = 3;
    private static int barriersTriangleBaseStartY;

    static {
        recalculateBarrierTriangleBaseStartY();
    }

    public static int getBarriersTriangleBaseStartY() {
        recalculateBarrierTriangleBaseStartY();
        return barriersTriangleBaseStartY;
    }

    private static void recalculateBarrierTriangleBaseStartY() {
        barriersTriangleBaseStartY = SpaceshipDisplay.getSpaceshipStartY() - TOTAL_MOB_SIZE - BARRIER_SIZE;
    }

    private BarrierDisplay() {}

}
