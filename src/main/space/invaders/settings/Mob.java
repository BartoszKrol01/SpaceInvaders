package main.space.invaders.settings;

import static main.space.invaders.settings.Image.IMAGE_SIZE;
import static main.space.invaders.settings.service.SettingsService.MOBS_IN_ONE_ROW_COUNT_DEFAULT;
import static main.space.invaders.settings.service.SettingsService.NUMBER_OF_MOB_ROWS_DEFAULT;

public class Mob {

    public static final int MOB_SIZE = IMAGE_SIZE;
    public static final int MOB_GAP = 18;
    public static final int TOTAL_MOB_SIZE = MOB_SIZE + MOB_GAP;
    public static final int NUMBER_OF_MOB_ROWS = NUMBER_OF_MOB_ROWS_DEFAULT;//todo:reload
    public static final int MOBS_IN_ONE_ROW_COUNT = MOBS_IN_ONE_ROW_COUNT_DEFAULT;//todo:reload
    public static final int TOTAL_NUMBER_OF_MOBS = NUMBER_OF_MOB_ROWS * MOBS_IN_ONE_ROW_COUNT;//todo:reload
    public static final int MOB_STEP_SIZE = 3;
    public static final int MOB_POSSIBLE_STEPS_SIDE = 18;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_X = 0;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_Y = 2;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_X = 6;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_Y = 4;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_X = 1;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_Y = 8;

    private Mob() {}

}
