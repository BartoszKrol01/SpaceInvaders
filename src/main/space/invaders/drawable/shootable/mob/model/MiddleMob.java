package main.space.invaders.drawable.shootable.mob.model;

import main.space.invaders.drawable.missile.HitBox;

import java.awt.Image;

import static main.space.invaders.constants.Mob.MIDDLE_MOB_HITBOX_DIFFERENCE_X;
import static main.space.invaders.constants.Mob.MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
import static main.space.invaders.constants.Mob.MOB_SIZE;

public class MiddleMob extends Mob {

    public MiddleMob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        super(stay, go, xLocation, yLocation, startRow);
    }

    @Override
    public HitBox getHitBox() {
        int x = super.xLocation + MIDDLE_MOB_HITBOX_DIFFERENCE_X;
        int y = super.yLocation + MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
        int width = MOB_SIZE - 2 * MIDDLE_MOB_HITBOX_DIFFERENCE_X;
        int height = MOB_SIZE - 2 * MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
        return new HitBox(x, y, width, height);
    }
}
