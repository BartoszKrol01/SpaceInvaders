package main.space.invaders.drawable.missile;

import java.awt.Rectangle;

public record HitBox(Rectangle hitbox) {

    public static boolean isThereCollision(HitBox hitBox1, HitBox hitBox2) {
        return hitBox1.hitbox().intersects(hitBox2.hitbox());
    }
}
