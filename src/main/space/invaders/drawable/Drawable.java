package main.space.invaders.drawable;

import java.awt.Graphics;

public interface Drawable {
    void draw(Graphics g);

    boolean isHostile();

    HitBox getHitBox();
}
