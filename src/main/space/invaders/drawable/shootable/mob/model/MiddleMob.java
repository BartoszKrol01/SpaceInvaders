package main.space.invaders.drawable.shootable.mob.model;

import main.space.invaders.drawable.missile.HitBox;

import java.awt.Image;
import java.awt.Rectangle;

import static main.space.invaders.gui.GameDisplayConstants.MIDDLE_MOB_HITBOX_DIFFERENCE_X;
import static main.space.invaders.gui.GameDisplayConstants.MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
import static main.space.invaders.gui.GameDisplayConstants.MOB_SIZE;

public class MiddleMob extends Mob {

    public MiddleMob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        super(stay, go, xLocation, yLocation, startRow);
    }

    @Override
    public HitBox getHitBox() {
        int x = super.xLocation + MIDDLE_MOB_HITBOX_DIFFERENCE_X;
        int y = super.yLocation + MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
        int width = MOB_SIZE - MIDDLE_MOB_HITBOX_DIFFERENCE_X;
        int height = MOB_SIZE - MIDDLE_MOB_HITBOX_DIFFERENCE_Y;
        return new HitBox(new Rectangle(x, y, width, height));
    }
}
