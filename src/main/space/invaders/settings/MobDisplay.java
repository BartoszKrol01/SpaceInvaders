package main.space.invaders.settings;

import static main.space.invaders.settings.Image.IMAGE_SIZE;

public class MobDisplay {

    public static final int MOB_SIZE = IMAGE_SIZE;
    public static final int MOB_GAP = 18;
    public static final int TOTAL_MOB_SIZE = MOB_SIZE + MOB_GAP;
    public static final int MOB_STEP_SIZE = 3;
    public static final int MOB_POSSIBLE_STEPS_SIDE = 18;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_X = 0;
    public static final int LOWER_MOB_HITBOX_DIFFERENCE_Y = 2;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_X = 6;
    public static final int UPPER_MOB_HITBOX_DIFFERENCE_Y = 4;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_X = 1;
    public static final int MIDDLE_MOB_HITBOX_DIFFERENCE_Y = 8;

    private MobDisplay() {}

}
