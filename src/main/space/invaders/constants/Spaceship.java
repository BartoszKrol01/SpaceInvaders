package main.space.invaders.constants;

import static main.space.invaders.constants.Image.IMAGE_SIZE;

public class Spaceship {

    public static final int SPACESHIP_SIZE = IMAGE_SIZE;
    public static final int SPACESHIP_START_X = GameDisplay.GAME_PANEL_WIDTH / 2;
    public static final int SPACESHIP_START_Y = GameDisplay.GAME_PANEL_HEIGHT - Mob.TOTAL_MOB_SIZE;
    public static final int FIRST_SPACESHIP_HITBOX_DIFFERENCE_X = 4;
    public static final int FIRST_SPACESHIP_HITBOX_DIFFERENCE_Y = 4;
    public static final int SECOND_SPACESHIP_HITBOX_DIFFERENCE_X = 1;
    public static final int SECOND_SPACESHIP_HITBOX_DIFFERENCE_Y = 15;

    private Spaceship() {}

}
