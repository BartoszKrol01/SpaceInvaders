package main.space.invaders.drawable.shootable.mob.model;

import main.space.invaders.drawable.missile.HitBox;

import java.awt.Image;

import static main.space.invaders.gui.panel.game.GameDisplayConstants.MOB_SIZE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.UPPER_MOB_HITBOX_DIFFERENCE_X;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.UPPER_MOB_HITBOX_DIFFERENCE_Y;

public class UpperMob extends Mob {

    public UpperMob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        super(stay, go, xLocation, yLocation, startRow);
    }

    @Override
    public HitBox getHitBox() {
        int x = super.xLocation + UPPER_MOB_HITBOX_DIFFERENCE_X;
        int y = super.yLocation + UPPER_MOB_HITBOX_DIFFERENCE_Y;
        int width = MOB_SIZE - UPPER_MOB_HITBOX_DIFFERENCE_X;
        int height = MOB_SIZE - UPPER_MOB_HITBOX_DIFFERENCE_Y;
        return new HitBox(x, y, width, height);
    }
}
