package main.space.invaders.drawable.missile;

import main.space.invaders.drawable.Drawable;
import main.space.invaders.utils.Distributor;

import java.time.Duration;
import java.time.LocalDateTime;

import static main.space.invaders.drawable.missile.HitBox.isThereCollision;
import static main.space.invaders.gui.GameDisplayConstants.GAME_PANEL_HEIGHT;
import static main.space.invaders.gui.GameDisplayConstants.MISSILE_HEIGHT;

public class MissileVerificationService {

    private static LocalDateTime lastMissileFired;
    private static final double MINIMAL_INTERVAL_BETWEEN_MISSILE_FIRE = 500;
    private static final int MAXIMUM_MISSILES_ON_SCREEN = 10; //todo: measure size of friendly missiles

    public static boolean shouldFireMoreMissiles() {
        if (lastMissileFired == null) {
            lastMissileFired = LocalDateTime.now();
            return true;
        }
        long durationBetweenLastMissileAndNow = Duration.between(lastMissileFired, LocalDateTime.now()).toMillis();
        if (Distributor.getMissiles().size() <= MAXIMUM_MISSILES_ON_SCREEN && durationBetweenLastMissileAndNow > MINIMAL_INTERVAL_BETWEEN_MISSILE_FIRE) {
            lastMissileFired = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public static boolean shouldRemoveMissile(Missile missile, Drawable drawable) {
        return missile.isHostile() != drawable.isHostile() && isThereCollision(drawable.getHitBox(), missile.getHitBox());
    }

    public static boolean isMissileOffScreen(Missile missile) {
        return missile.getYLocation() > GAME_PANEL_HEIGHT || missile.getYLocation() + MISSILE_HEIGHT < 0;
    }
}
