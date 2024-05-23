package main.space.invaders.constants;

public class Barrier {

    public static final int BARRIER_SIZE = 2;
    public static final int BARRIERS_TRIANGLE_BASE_START_Y = Spaceship.SPACESHIP_START_Y - Mob.TOTAL_MOB_SIZE - BARRIER_SIZE;
    public static final int BARRIERS_TRIANGLE_BASE = 41;
    public static final int BARRIERS_TRIANGLE_BASE_WIDTH = BARRIERS_TRIANGLE_BASE * BARRIER_SIZE;
    public static final int GAP_BETWEEN_BARRIERS = ((GameDisplay.GAME_PANEL_WIDTH - (2 * GameDisplay.SIDE_PANEL_GAP)) - 2 * BARRIERS_TRIANGLE_BASE_WIDTH) / 2 - BARRIERS_TRIANGLE_BASE_WIDTH / 2;
    public static final int BARRIERS_TRIANGLE_HEIGHT = (BARRIERS_TRIANGLE_BASE + 1) / 2;
    public static final int BARRIERS_TRIANGLES_NUMBER = 3;

    private Barrier() {}

}
