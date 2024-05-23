package main.space.invaders.constants;

import static main.space.invaders.constants.Image.IMAGE_SIZE;

public class Spaceship {

    public static final int SPACESHIP_SIZE = IMAGE_SIZE;
    public static final int SPACESHIP_START_X = GameDisplay.GAME_PANEL_WIDTH / 2;
    public static final int SPACESHIP_START_Y = GameDisplay.GAME_PANEL_HEIGHT - Mob.TOTAL_MOB_SIZE;
    public static final int SPACESHIP_HITBOX_DIFFERENCE = 4;

    private Spaceship() {}

}
