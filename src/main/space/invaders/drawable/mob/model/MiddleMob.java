package main.space.invaders.drawable.mob.model;

import main.space.invaders.drawable.HitBox;

import java.awt.Image;

public class MiddleMob extends Mob {

    public MiddleMob(Image stay, Image go, int xLocation, int yLocation, int startRow) {
        super(stay, go, xLocation, yLocation, startRow);
    }

    @Override
    public HitBox getHitBox() {
        return null;
    }
}
