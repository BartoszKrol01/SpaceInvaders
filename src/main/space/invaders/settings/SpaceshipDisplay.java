package main.space.invaders.settings;

import static main.space.invaders.settings.Image.IMAGE_SIZE;

public class SpaceshipDisplay {

    public static final int SPACESHIP_SIZE = IMAGE_SIZE;
    public static final int FIRST_SPACESHIP_HITBOX_DIFFERENCE_X = 4;
    public static final int FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y = 4;
    public static final int SECOND_SPACESHIP_HITBOX_DIFFERENCE_X = 1;
    public static final int SECOND_SPACESHIP_HITBOX_DIFFERENCE_Y = 15;
    public static int spaceshipStartX;
    public static int spaceshipStartY;

    static {
        recalculateSpaceshipStartPoint();
    }

    public static int getSpaceshipStartX() {
        recalculateSpaceshipStartPoint();
        return spaceshipStartX;
    }

    public static int getSpaceshipStartY() {
        recalculateSpaceshipStartPoint();
        return spaceshipStartY;
    }

    private static void recalculateSpaceshipStartPoint() {
        spaceshipStartX = GameDisplay.getGamePanelWidth() / 2;
        spaceshipStartY = GameDisplay.getGamePanelHeight() - MobDisplay.TOTAL_MOB_SIZE;
    }

    private SpaceshipDisplay() {}

}
