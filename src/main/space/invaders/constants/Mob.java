package main.space.invaders.constants;

public class Mob {

    public static final int MOB_SIZE = Image.IMAGE_SIZE;
    public static final int MOB_GAP = 18;
    public static final int HALF_MOB_GAP = MOB_GAP / 2;
    public static final int TOTAL_MOB_SIZE = MOB_SIZE + MOB_GAP;
    public static final int NUMBER_OF_MOB_ROWS = 5;
    public static final int MOBS_IN_ONE_ROW_COUNT = 11;
    public static final int TOTAL_NUMBER_OF_MOBS = NUMBER_OF_MOB_ROWS * MOBS_IN_ONE_ROW_COUNT;
    public static final int MOB_STEP_SIZE = 3;
    public static final int MOB_POSSIBLE_STEPS_SIDE = 9;
    public static final int FIRST_MOB_POSSIBLE_STEPS_DOWN = 5;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_X = 0;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_Y = 2;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_X = 6;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_Y = 4;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_X = 1;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_Y = 8;

    private Mob() {}

}
