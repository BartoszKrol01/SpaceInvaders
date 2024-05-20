package main.space.invaders.drawable;

import main.space.invaders.drawable.missile.HitBox;

import java.awt.Graphics;

public interface Drawable {
    void draw(Graphics g);

    boolean isHostile();

    HitBox getHitBox();
}
