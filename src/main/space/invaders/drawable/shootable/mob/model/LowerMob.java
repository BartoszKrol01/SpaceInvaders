package main.space.invaders.drawable.shootable.mob.model;

import main.space.invaders.drawable.missile.HitBox;

import java.awt.Image;

import static main.space.invaders.gui.panel.game.GameDisplayConstants.LOWER_MOB_HITBOX_DIFFERENCE;
import static main.space.invaders.gui.panel.game.GameDisplayConstants.MOB_SIZE;

public class LowerMob extends Mob {

    public LowerMob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        super(stay, go, xLocation, yLocation, startRow);
    }

    @Override
    public HitBox getHitBox() {
        int x = super.xLocation + LOWER_MOB_HITBOX_DIFFERENCE;
        int y = super.yLocation + LOWER_MOB_HITBOX_DIFFERENCE;
        int size = MOB_SIZE - LOWER_MOB_HITBOX_DIFFERENCE;
        return new HitBox(x, y, size, size);
    }
}
