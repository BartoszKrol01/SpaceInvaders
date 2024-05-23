package main.space.invaders.drawable.missile;

import java.awt.Rectangle;

public class HitBox extends Rectangle {

    public HitBox(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public static boolean isThereCollision(HitBox hitBox1, HitBox hitBox2) {
        return hitBox1.intersects(hitBox2);
    }
}
